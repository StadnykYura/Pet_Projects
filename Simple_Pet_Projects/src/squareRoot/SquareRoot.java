package squareRoot;

public class SquareRoot {
      
	public static void main(String[] args) {
		
		double a = 3;
		double b = 2.5;
		double c = -0.5;
//		System.out.println("���� ���������� ������� ������ ������ ax*x+bx+c=0, ��� 3x*x+2.5*x-0.5=0");
		// ��������� ����������� �� �������� b*b-4ac
		
		double D = (b*b)-(4*a*c);
		
		if (a != 0 && b != 0 && c != 0 ) {
		
			if (D > 0) {
				double x1 = ((-b) + Math.sqrt(D))/(2*a);
				double x2 = ((-b) - Math.sqrt(D))/(2*a);
				System.out.println("x1=" + x1 + "\n" + "x2=" + x2);
			double k1 = a*x1*x1+b*x1+c;
				double k2 = a*x2*x2+b*x2+c;
				System.out.println("k1 = " + k1 + "\n"+ "k2 = " + k2);
				if (k1 == 0 && k2==0){
					System.out.println("����'���� �����");
				}
				
				
			} else if (D == 0) {
				double x1 = (-b)/(2*a);
				double x2 = x1;
				System.out.println("x1=" + x1 + "\n" + "x2=" + x2);
			
//			double k1 = a*x1*x1+b*x1+c;
//			double k2 = a*x2*x2+b*x2+c;
//			System.out.println("k1 = " + k1 + "\n"+ "k2 = " + k2);
//			if (k1 == 0 || k2==0){
//				System.out.println("����'���� �����");
//			} 
			} else {
				System.out.println("x1=" + "\n" + "x2=");
//			System.out.println("г������ �� �� ����'����, ������� D<0");
			}
			
		} else if ((a != 0 && b == 0 && c == 0) || (a == 0 && b !=0 && c == 0)) {
			double x1 = 0;
			double x2 = x1;
			System.out.println("x1=" + x1 + "\n" + "x2=" + x2);
			
		
		} else if (a!= 0 && b == 0 && c!=0 ) {
			double x1 = Math.sqrt(-(c/a));
			double x2 = - Math.sqrt(-(c/a));
			System.out.println("x1=" + x1 + "\n" + "x2=" + x2);
			
	
		} else if (a !=0 && b != 0 && c==0) {
			double x1 = 0;
			double x2 = -(b/a);
			System.out.println("x1=" + x1 + "\n" + "x2=" + x2);
			
		} else {
			System.out.println("x1=" + "\n" + "x2=");
		}
			
	
}
}




