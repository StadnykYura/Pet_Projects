package patternCommand;

public class EchoCommand implements Command {

	private String arg;

	public EchoCommand(String arg) {
		
		this.arg = arg;
	}

	public void execute() {
		System.out.println(arg);
		
	}
	
}
