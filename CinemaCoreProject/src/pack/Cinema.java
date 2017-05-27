package pack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cinema {

	private Map<Days, Schedule> schedules;
	private Time open;
	private Time close;

	
	public Cinema(Time open, Time close) {

		this.schedules = new TreeMap<Days, Schedule>();
		this.open = new Time(7, 0);
		this.close = new Time(23, 55);
		for (Days day : Days.values()) {
			schedules.put(day, new Schedule());
		}

	}

	public void addMovieToEveryDay(Movie movie, Time startTime) {
		int OT = open.convertToMinutes();
		int ET = close.convertToMinutes();
		if (OT > startTime.convertToMinutes()
				|| ET < startTime.convertToMinutes() + movie.getDuration().convertToMinutes()) {
			System.out.println("Cant add a movie to schedule, because of the oppening and closing time");
		} else {
			for (Days day : Days.values()) {
				if (!schedules.get(day).addSeance(new Seance(movie, startTime))) {
					System.out
							.println("Can't add a seance, because another film will be showed at this time on " + day);
				}
			}
		}

	}

	public void addSeanceForSpecialDay(Seance newSeance) {
		System.out
				.println("Choose a day for adding one seance for special Day(write a number of the week day from 1-7)");
		Days seanceDay = null;
		do {
			for (Days day : Days.values()) {
				System.out.println("For " + day + " enter: " + (day.ordinal() + 1));
			}

			int weekDaynumber = inputInt();
			
				if (weekDaynumber > 0 && weekDaynumber < 8){
					seanceDay = Days.values()[weekDaynumber - 1];
				} else {
					System.out.println("You wrote a wrong number" + "\n" + "Write again a number of the week day");
				}
			
			
		} while (seanceDay == null);

		schedules.get(seanceDay).addSeance(newSeance);

	}

	public void removeMovieFromAllSchedule(Movie movie) {

		for (Days day : Days.values()) {
			// 1variant
			Iterator<Seance> iterSeance = schedules.get(day).getSeances().iterator();
			while (iterSeance.hasNext()) {
				if (iterSeance.next().getMovie().getTitle().equalsIgnoreCase(movie.getTitle())) {
					iterSeance.remove();
				}
			}

			/*
			 * doesn't work simple forEach iteration -
			 * java.util.ConcurrentModificationException, because Removing
			 * objects while going through Collection USE ITERATOR in this
			 * method or in Schedule Class
			 */

			// for (Seance seance : schedules.get(day).getSeances()) {
			// if
			// (seance.getMovie().getTitle().equalsIgnoreCase(movie.getTitle()))
			// {
			// schedules.get(day).removeSeance(seance);
			// } else {
			// System.out.println("There is no such seance with this name or at
			// this time, pls check");
			// }
			// }
		}
	}

	public void removeSpecaialSeanceOfMovieInSpecialDay(Seance seanceToRemove, String specialDay) {
		for (Days day : Days.values()) {
			if (day.name().equalsIgnoreCase(specialDay)) {
				schedules.get(day).removeSeance(seanceToRemove);

				// Iterator <Seance> iterSeance =
				// schedules.get(day).getSeances().iterator();
				// while(iterSeance.hasNext()){
				// Seance seance = iterSeance.next();
				// if
				// (seance.getMovie().getTitle().equalsIgnoreCase(seanceToRemove.getMovie().getTitle())
				// && seance.getStartTime().convertToMinutes() ==
				// seanceToRemove.getStartTime().convertToMinutes()){
				// iterSeance.remove();
				// }
				// }
			}
		}

	}

	public Movie selectMovie() {

		Set<Movie> movieSet = new TreeSet<>();
		int i = 0;
		for (Days day : Days.values()) {
			for (Seance seance : schedules.get(day).getSeances()) {
				movieSet.add(seance.getMovie());
			}
		}
		for (Movie movie : movieSet) {
			System.out.println("Write down " + ++i + " for selecting movie: " + movie.getTitle());
		}
		
		int command = inputInt();

		i = 0;
		for (Movie movie : movieSet) {
			if (command == ++i) {
				return movie;
			}
		}

		// Map <Movie, Integer> mapMovies = new TreeMap<>();
		// int i = 0;
		// for (Days day : Days.values()) {
		// for (Seance seance : schedules.get(day).getSeances()){
		// mapMovies.put(seance.getMovie(), ++i);
		// }
		// }
		// i=0;
		// for (Movie movie : mapMovies.keySet()) {
		// System.out.println("Choose number " + ++i + " for selecting movie " +
		// movie.getTitle());
		// }
		//
		// int command = sc.nextInt();
		// i=0;
		// for (Movie movie : mapMovies.keySet()) {
		// if (command == ++i){
		// return movie;
		// }
		// }
		return null;
	}

	public Days selectDay() {
		System.out
				.println("Select a day (write a number of the week day from 1-7)");
		Days seanceDay = null;
		do {
			for (Days day : Days.values()) {
				System.out.println("For " + day + " enter: " + (day.ordinal() + 1));
			}

			int weekDaynumber = inputInt();
			if (weekDaynumber > 0 && weekDaynumber < 8){
				seanceDay = Days.values()[weekDaynumber - 1];
			} else {
				System.out.println("You wrote a wrong number" + "\n" + "Write again a number of the week day");
			}
		} while (seanceDay == null);
		
		return seanceDay;
	}
	
	public Time inputStartTime(){
		
		System.out.println(
				"Write down a Starting time for the film in such format like '00:00', where firts two zeros "
						+ "shows hours, and next two zeros after sign ':' shows minutes in 24 hours day");
		String startingTime = inputLine();
		
		String delimiter = ":";
		String[] temp;
		temp = startingTime.split(delimiter);
		int startHour = Integer.parseInt(temp[0]);
		int startMinutes = Integer.parseInt(temp[1]);
		
		return new Time(startHour, startMinutes);
	}
	
	public Seance selectSeance(Days specialDay){
		Set<Seance> seanceSet = new TreeSet<>();
		int i = 0;
		
			for (Seance seance : schedules.get(specialDay).getSeances()) {
				seanceSet.add(seance);
			}
		
		for (Seance seance : seanceSet) {
			System.out.println("Write down " + ++i + " for selecting seance: " + seance);
		}
		int command = inputInt();

		i = 0;
		for (Seance seance : seanceSet) {
			if (command == ++i) {
				return seance;
			}
		}
		return null;
	}

	public Map<Days, Schedule> getSchedules() {
		return schedules;
	}
	
	public Movie inputNewMovie(){
		
		System.out.println("Write down a name of the new movie");
		String newMovie = this.inputLine();
		
		
		System.out.println("Write down a duration of the new movie in minutes in such format like '000'");
		int duration = inputInt();
		
		
		return new Movie(newMovie, new Time(duration/60, duration%60));
	}
	
	private String inputLine(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();	
	}
	
	private int inputInt(){
		return new Scanner(System.in).nextInt();
	}

}
