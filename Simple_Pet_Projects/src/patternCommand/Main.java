package patternCommand;

public class Main {

	public static void main(String[] args) {
		
		Application.main(new String [] {"echo", "test", "test"});
		Application.main(new String [] { "exit", "test" }); 
		Application.main(new String[] { "date", "before" }); 
		Application.main(new String[] { "exit"});
		Application.main(new String[] {"echo", "test"});
		Application.main(new String[] { "date", "now" });
		Application.main(new String[] { "help"});
		Application.main(new String[] { "help", "aww"});
		Application.main(new String[] { "echo", ""});		
		Application.main(new String[] { "echo", null});		
	}
	
}
