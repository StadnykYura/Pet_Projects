package employeeSalarySortAndSerializeDeserelize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		EmployerHourlyWage employer1 = new EmployerHourlyWage(1, "Yura", 20);
		EmployerHourlyWage employer2 = new EmployerHourlyWage(2, "Taras", 15);
		EmployerHourlyWage employer3 = new EmployerHourlyWage(3, "Vova", 17);
		EmployerFixedPayment employer4 = new EmployerFixedPayment(4, "Orest", 5000);
		EmployerFixedPayment employer5 = new EmployerFixedPayment(5, "Yulia", 6000);
		EmployerFixedPayment employer6 = new EmployerFixedPayment(6, "Igor", 4000);
		EmployerFixedPayment employer7 = new EmployerFixedPayment(7, "Lida", 6000);
		
		
		
		LinkedList<Employer> employees = new LinkedList<>();
		
		employees.add(employer1);
		employees.add(employer2);
		employees.add(employer3);
		employees.add(employer4);
		employees.add(employer5);
		employees.add(employer6);
		employees.add(employer7);
		
		// task a) for sorting employees by amount of salary (descending order) ; if salary equals, then by name.
		Collections.sort(employees, new EmployeeComparator());
		
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}
		
		
		// task b) write information about first five employees from sorted Collection
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(employees.get(i));
		}
		
		
		//task c) write ID of last three employees from sorted Collection 
		for (int i = employees.size()-3; i < employees.size(); i++) {
			System.out.println(employees.get(i).getId());
		}
		System.out.println();
		// or about last three employees from first fifth
		int count = 0;
		for (int i = 0; i < 5; i++) {
			count++;
			if (count > 2){
				System.out.println(employees.get(i).getId());	
			}
		}
		
		System.out.println();
		// task d) writing and reading collection to (from) File
		writeEmployeesToFile(employees);
		
//		LinkedList<Employer> fromFile = readEmployeesFromFile();
		for (Employer  employer : readEmployeesFromFile()) {
			System.out.println(employer);
		}
		
		//task e) 
		
		
		
		
	}
		//task 
	
	public static void writeEmployeesToFile(LinkedList<Employer> employees){
		
		try (	FileOutputStream fos = new FileOutputStream("file.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos) )
		{
					oos.writeObject(employees);
					
		} catch (IOException e){
			System.out.println("Помилка Серелізації" + e);
			e.printStackTrace();
		}
		
	}
	
	public static LinkedList<Employer> readEmployeesFromFile(){
		LinkedList<Employer> result = null;
		try (	FileInputStream fis = new FileInputStream("file.txt");
				ObjectInputStream ois = new ObjectInputStream(fis) )
		{ 
			result = (LinkedList<Employer>) ois.readObject();
		} catch (IOException e) {
			System.out.println("Помилка Десерилізації"+ e);
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		
		return result;
		
	}
	
	
}
