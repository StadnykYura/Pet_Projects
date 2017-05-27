package pack;

public class Time {

	private int hour;
	private int min;

	public Time() {
		// TODO Auto-generated constructor stub
	}

	public Time(int hour, int min) {
	
		this.hour = hour;
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour > 24 || hour < 0) {
			System.out.println("error time duration");
		} else {
			this.hour = hour;
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		if (min > 60 || min < 0) {
			System.out.println("error time duration");
		} else {
			this.min = min;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (min < 10 && hour < 10 ) {
			return " [hour=0" + hour + ", min=0" + min + "]";
		} else if (hour < 10){
			return " [hour=0" + hour + ", min=" + min  + "]";
		} else if (min < 10) {
			return " [hour=" + hour + ", min=0" + min  + "]";
		}else {
			return " [hour=" + hour + ", min=" + min  + "]";
		}
		
	}

	public String countDuration() {
	
		int duration = this.getHour()*60+this.getMin(); 
		
		return "Duration of the film: " + duration + " min. ";
	}

	public int convertToMinutes(){
		return this.getHour()*60+this.getMin();
	}
}
