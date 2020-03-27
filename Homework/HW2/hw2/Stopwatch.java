package hw2;
/*
 * The class contains:
 * 1. private datafields called startTime and endTime with getter methods
 * 2. A  no-arg constructor that initializes the start time with the current time
 * 3. a method named start () that resets the startTime to the currenTime
 * 4. A method named Stop() that sets the endTime to the currentTime
 * 5. A method named elapsed time () thar returns the elapsed time for the stopwatch in 
 * milliseconds
 * 
 * Test program:
 * 1. test program that measures the execution time of sorting 100,000 numbers using selection
 * sort
 */
import java.util.Date;

public class Stopwatch {
	private double startTime;
	private double endTime;
	
	public Stopwatch() {
		long totalMilliseconds= System.currentTimeMillis();
		long totalSeconds= totalMilliseconds/100;
		long currentSecond= totalSeconds%60;
		long totalMinutes= totalSeconds/60;
		long currentMinute= totalMinutes%60;
		long totalHours= totalMinutes/60;
		long currentHour= totalHours % 24;
		
		this.startTime= (double) currentHour;
		
	}
	
	public void setStartTime(double startTime) {
		this.startTime=startTime;
	}
	
	public void setEndTime(double endtime) {
		this.endTime= endtime;
	}

	public double getStart() {
		return startTime;
	}
	
	public double getEnd() {
		return endTime;
	}
	
	public void stop(double currentHour) {
		this.endTime= currentHour;
	}
	
	public long elapsed() {
		return (long) ((endTime- startTime)*1000); 
	}
	public static void main(String[] args) {
		Stopwatch game1= new Stopwatch();
		game1.setStartTime(12);
		game1.setEndTime(14);
		System.out.println(game1.getStart());
		System.out.println(game1.elapsed()+ " milliseconds");
	}

}
