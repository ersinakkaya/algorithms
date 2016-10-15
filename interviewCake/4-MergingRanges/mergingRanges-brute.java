public class Meeting {

    int startTime;
    int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public static int[][] condenseMeetingTimes(int[][] times){
    	int[][] resp = new int[times.length][2];

    	int counter = 0;
		for(int i = 0; i < times.length; i++){
			int start = times[i][0];
			int end = times[i][1];
			for(int j = 1; j < times.length; j++){
				if(times[j][0] <= end && times[j][0] > start){
					resp[counter][0] = start;
					resp[counter][1] = times[j][1];
					counter++;
					break;
				}

			}
		}
		return resp;
    }

    public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
    }

    public static void main (String args[]){
    	int[][] times =  {{0, 1}, {3, 5}, {4, 8}, {10, 12}, {9, 10}};
    	int[][] resp = condenseMeetingTimes(times);

    	for(int[] data : resp){
    		System.out.println(data[0] + ", " + data[1]);
    	}
    }
}