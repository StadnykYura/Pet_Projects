package employeeSalarySortAndSerializeDeserelize;

public class EmployerHourlyWage extends Employer {

	double hourlyRate;


	public EmployerHourlyWage(int id, String name, double hourlyRate) {
		super(id, name);
		this.hourlyRate = hourlyRate;
	}



	public double getHourlyRate() {
		return hourlyRate;
	}



	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}



	@Override
	double calculateAvarageSalary() {
		// TODO Auto-generated method stub
		return 20.8*8*this.hourlyRate;
	}



	
}
