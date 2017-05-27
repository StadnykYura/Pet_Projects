package employeeSalarySortAndSerializeDeserelize;

public class EmployerFixedPayment extends Employer {

	double fixedPayment;

	public EmployerFixedPayment(int id, String name, double fixedPayment) {
		super(id, name);
		this.fixedPayment = fixedPayment;
	}

	public double getFixedPayment() {
		return fixedPayment;
	}

	public void setFixedPayment(double fixedPayment) {
		this.fixedPayment = fixedPayment;
	}

	@Override
	double calculateAvarageSalary() {
		// TODO Auto-generated method stub
		return this.fixedPayment;
	}
	

	
	
	
}
