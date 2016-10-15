#Merging Ranges
To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime. These integers represent the number of 30-minute blocks past 9:00am.

```
public class Meeting {

    int startTime;
    int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
    }
}

```

for example:

```
  	new Meeting(2, 3); // meeting from 10:00 – 10:30 am
	new Meeting(6, 9); // meeting from 12:00 – 1:30 pm
```

Write a function condenseMeetingTimes() that takes a list of meeting time ranges and returns a list of condensed ranges.

For example, given:

```
  [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
```

your function would return:

```
  [(0, 1), (3, 8), (9, 12)]
```

Do not assume the meetings are in order. The meeting times are coming from multiple teams.

Write a solution that's efficient even when we can't put a nice upper bound on the numbers representing our time ranges. Here we've simplified our times down to the number of 30-minute slots past 9:00 am. But we want the function to work even for very large numbers, like Unix timestamps. In any case, the spirit of the challenge is to merge meetings where startTime and endTime don't have an upper bound.