package pack;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Main {
	
	
	
	public static int getInt()   {
		Scanner sc = new Scanner(System.in);
		try{
			return sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("You wrote not a number");
			return 0;
		}
//		try {
//			
//		} catch (InputMismatchException IME) {
//			System.out.println("You wrote not a number");
//			IME.printStackTrace();
//		} finally {
//			sc.close();
//		}
//		return 0;
	}
	
	public static void main(String[] args) {

		Cinema cinema = new Cinema(new Time(7, 0), new Time(23, 55));
		while (true) {
			try {
				
			
			
			System.out.println("Choose a number from 1-4 for doing staff: " + "\n"
					+ "1. Adding new movie to every day of the week" + "\n"
					+ "2. Adding seance to SpecialDay with existing movie" + "\n" + "3. Remove movie from all schedule"
					+ "\n" + "4. Remove special seance of movie in special day");

			
			
			int switchNumber = getInt();
			
			

			Movie currentMovie = null;
			Days currentDay = null;
			Time currentST = null;
			Seance currentSeance = null;
			switch (switchNumber) {
			case 1:
				try {
					currentMovie = cinema.inputNewMovie();
					currentST = cinema.inputStartTime();
					
				} catch (InputMismatchException | NumberFormatException nfe) {
					System.out.println("You wrote wrong number or character");
					System.out.println();
				}
				if (currentST == null || currentMovie == null){
					break;
				}

				cinema.addMovieToEveryDay(currentMovie, currentST);

				System.out.println();

				for (Days day : Days.values()) {
					System.out.println(day + ":");
					System.out.println(cinema.getSchedules().get(day));
				}
				break;

			case 2:
				// System.out.println(
				// "Choose a film from existing films to add new Seance. Write
				// down a name of the film to choose");
				// Movie tempMovie = null;
				// String movieName = sc.nextLine();
				// for (Days day : Days.values()) {
				// for (Seance seance :
				// cinema.getSchedules().get(day).getSeances()) {
				// if (seance.getMovie().getTitle().equalsIgnoreCase(movieName))
				// {
				// tempMovie = seance.getMovie();
				// break;
				// }
				// }
				// if (tempMovie != null) {
				// break;
				// }
				// }
				// if (tempMovie == null) {
				// System.out.println("The movie with this name doesn't exist");
				// return;
				// }

				currentMovie = cinema.selectMovie();
				currentST = cinema.inputStartTime();

				cinema.addSeanceForSpecialDay(new Seance(currentMovie, currentST));
				System.out.println();

				for (Days day : Days.values()) {
					System.out.println(day + ":");
					System.out.println(cinema.getSchedules().get(day));
				}

				break;
			case 3:

				currentMovie = cinema.selectMovie();

				cinema.removeMovieFromAllSchedule(currentMovie);
				System.out.println();

				for (Days day : Days.values()) {
					System.out.println(day + ":");
					System.out.println(cinema.getSchedules().get(day));
				}

				break;
			case 4:

				currentDay = cinema.selectDay();
				String stringValueCurrentDay = currentDay.name();
				System.out.println("Choose seance for deletting");
				currentSeance = cinema.selectSeance(currentDay);
				cinema.removeSpecaialSeanceOfMovieInSpecialDay(currentSeance, stringValueCurrentDay);

				for (Days day : Days.values()) {
					System.out.println(day + ":");
					System.out.println(cinema.getSchedules().get(day));
				}

				break;
			
			default:
				System.out.println("You choosed wrong number or character");
				System.out.println();
				break;
			}
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("You choosed/wrote wrong number/character");
			}
		}

	}

}
