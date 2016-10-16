package Test;
import java.util.*;
import java.util.Comparator;

public class Meeting{

	int startTime;
	int endTime;

	public Meeting(int startTime, int endTime){
		// number of 30 min blocks pass 9:00 am

		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String toString(){
		return String.format("%d, %d", startTime, endTime);
	}

	public static List<Meeting> mergeRanges(List<Meeting> meetings){
		// sort meetings by start times
		List<Meeting> sortedMeetings = new ArrayList<Meeting>(meetings);
		Collections.sort(sortedMeetings, new Comparator<Meeting>(){
			public int compare(Meeting m1, Meeting m2){
				return m1.startTime - m2.startTime;
			}
		});

		//initialize mergedMeetings with the earliest meeting
		List<Meeting> mergedMeetings = new ArrayList<Meeting>();
		mergedMeetings.add(sortedMeetings.get(0));

		for(Meeting currentMeeting : sortedMeetings){
			Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

			//if the current and last meetings overlap, use the latest end time
			if(currentMeeting.startTime <= lastMergedMeeting.endTime){
				lastMergedMeeting.endTime = Math.max(lastMergedMeeting.endTime, currentMeeting.endTime);

			}else{
				//add the current meeting since it doesn't overlap
				mergedMeetings.add(currentMeeting);
			}

		}

		return mergedMeetings;
	}

	public static void main(String[] args){
		new Meeting(2, 3);
		new Meeting(6, 9);
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(2, 5));
		meetings.add(new Meeting(4, 7));
		meetings.add(new Meeting(8, 11));
		meetings.add(new Meeting(1, 6));
		meetings.add(new Meeting(14, 17));
		meetings.add(new Meeting(18, 20));
		List<Meeting> mergedMeetings = mergeRanges(meetings);
		
		for(Meeting meet : mergedMeetings){
			System.out.println(meet.startTime + ", " + meet.endTime);
		}
	}
}

//Time complexity O(n log n) time
//Space complexity O(n) space
