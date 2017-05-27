package patternCommand;

public class DateCommand implements Command{

	@Override
	public void execute() {
		System.out.println(System.currentTimeMillis());
		
	}

	
	
}
