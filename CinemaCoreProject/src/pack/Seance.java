package pack;

public class Seance implements Comparable<Seance>{

	private Movie movie;
	private Time startTime;
	private Time endTime;

	public Seance(Movie movie, Time startTime) {
		
		this.movie = movie;
		this.startTime = startTime;

		int hoursEnd = startTime.getHour() + movie.getDuration().getHour();
		int minsEnd = startTime.getMin() + movie.getDuration().getMin();

		if (minsEnd < 60) {
			this.endTime = new Time(hoursEnd, minsEnd);
		} else {
			this.endTime = new Time(hoursEnd + 1, minsEnd % 60);
		}

	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Seance [movie=" + movie + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	@Override
	public int compareTo(Seance s) {
		// TODO Auto-generated method stub
		
//		1 variant SORT by
//		return this.startTime.getHour() - s.getStartTime().getHour();
		
		
//		2 variant Sort by
		if(this.startTime.getHour() > s.getStartTime().getHour()){
			return 1;
		} else if (this.startTime.getHour() < s.getStartTime().getHour()){
			return -1;
		} else { 
			return this.startTime.getMin() - s.getStartTime().getMin();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Seance other = (Seance) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	
	

}
