package com.interview.cake;

class TemperatureTracker{
	
	private int temperature;
	private Integer maxTemp;
	private Integer minTemp;
	private int totalTemp;
	private Double totalSum = 0.0;
	private Double mean = 0.0;
	private int mode;
	int[] occurences = new int[111];
	int maxOccurences = 0;//for mode

	public boolean insert(int temperature){
		occurences[temperature]++;
		if(occurences[temperature] > maxOccurences){
			this.mode = temperature;
			maxOccurences = occurences[temperature];
		}

		this.totalTemp++;
		this.totalSum += temperature;
		this.mean = totalSum / totalTemp;

		if(this.maxTemp == null || this.maxTemp <= temperature){
			this.maxTemp = temperature;
		}
		
		if(this.minTemp == null || this.minTemp >= temperature){
			this.minTemp = temperature;
		}
		
		return true;
	}

	public int getMax(){
		return this.maxTemp;
	}

	public int getMin(){
		return this.minTemp;
	}

	public double getMean(){
		return this.mean;
	}

	public int getMode(){
		return mode;
	}

	public static void main(String args[]){
		TemperatureTracker tracker = new TemperatureTracker();
		tracker.insert(1);
		tracker.insert(3);
		tracker.insert(5);
		tracker.insert(8);
		tracker.insert(12);
		tracker.insert(6);
		tracker.insert(5);
		tracker.insert(1);
		tracker.insert(2);
		tracker.insert(1);
		
		System.out.println("max:" + tracker.getMax());
		System.out.println("min:" + tracker.getMin());
		System.out.println("mean:" + tracker.getMean());
		System.out.println("mode:" + tracker.getMode());
	}
}

/*
Output:
max:12
min:1
mean:4.4
mode:1

*/