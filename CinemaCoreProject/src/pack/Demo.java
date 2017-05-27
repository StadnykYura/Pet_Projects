package pack;

public class Demo {
	
	public static void main(String[] args) {
		
		Movie movie = new Movie("term", new Time(1, 5));
		System.out.println(movie);
		System.out.println(movie.getDuration());
		
		int h = 9;
		int min = 45;
		
		h = (h + (min + 90)/60) % 24;
		min = (min + 90)%60;
		
		System.out.println(h);
		System.out.println(min);
		
		System.out.println(12%24);
		System.out.println(135%60);
		
	}
	
}
