package pack;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	Set<Seance> seances;

	public Schedule() {

		this.seances = new TreeSet<Seance>();

	}

	public boolean addSeance(Seance newSeance) {

		int newST = newSeance.getStartTime().convertToMinutes();
		int newET = newSeance.getEndTime().convertToMinutes();
		boolean conflict = false;
		for (Seance seance : seances) {
			int currentST = seance.getStartTime().getHour() * 60 + seance.getStartTime().getMin();
			int currentET = seance.getEndTime().getHour() * 60 + seance.getEndTime().getMin();
			if ((newST < currentST && newET > currentST) || (newST > currentST && newST < currentET)) {

				conflict = true;
			}
		}
		if (!conflict) {
			return seances.add(newSeance);
		} else {
			return false;

		}

	}

	public void removeSeance(Seance seanceToRemove) {
		
		Iterator <Seance> iterSeance = this.seances.iterator();
		
		while (iterSeance.hasNext()){
			Seance seance = iterSeance.next();
			if (seance.getMovie().getTitle().equalsIgnoreCase(seanceToRemove.getMovie().getTitle())
					&& seance.getStartTime().convertToMinutes() == seanceToRemove.getStartTime().convertToMinutes()){
				iterSeance.remove();
			}
		}
				
		
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	@Override
	public String toString() {
		String s = "";
		for (Seance seance : seances) {
			s = s.concat(String.format("%s\n", seance));
		}
		return s;

	}

}
