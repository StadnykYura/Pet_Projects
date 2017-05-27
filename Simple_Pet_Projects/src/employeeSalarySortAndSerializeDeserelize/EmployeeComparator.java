package employeeSalarySortAndSerializeDeserelize;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employer>{

	@Override
	public int compare(Employer o1, Employer o2) {

		if (o1.calculateAvarageSalary() > o2.calculateAvarageSalary()){
			return -1;
		} else if (o1.calculateAvarageSalary() < o2.calculateAvarageSalary()){
			return 1;
		} else {
			return o1.getName().compareTo(o2.getName());
		}
		
		
		
	}

}
