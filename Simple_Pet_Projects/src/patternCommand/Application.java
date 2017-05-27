package patternCommand;

public class Application {

	public static void main(String[] args) {
		
//		1) Варіант з IF
		
		if (args == null || args.length<=0 || args.length>2 || 
			(args.length==2 && args[0]==null) || (args.length==2 && args[0].equals("")) ||
			(args.length==2 && args[1]==null) || (args.length==2 && args[1].equals(""))
			) {
			System.out.println("Error");
		} else if (args.length==1 && args[0].equals("help")) {
			Command command = new HelpCommand();
			command.execute();
		} else if (args.length==2 && args[0].equals("echo")){
			Command command = new EchoCommand(args[1]);
			command.execute();
		} else if (args.length==2 && args[0].equals("date") && args[1].equals("now")){
			Command command = new DateCommand();
			command.execute();
		} else if (args.length==1 && args[0].equals("exit")){
			Command command = new ExitCommand();
			command.execute();
		} else {
			System.out.println("Error");
		}
		
		// Варіант із світч
		
		
//		if (args != null ) {
//			
//			if (args.length > 0) {
//				
//				switch (args[0].toLowerCase()) {
//				case "help": 
//					if (args.length == 1){
//						Command command = new HelpCommand();
//						command.execute();
//					} else {
//						System.out.println("Error");
//					}
//					break;
//				case "echo":
//					if(args.length==2){
//						if(args[1] != null  && !(args[1].equals(""))){
//							Command command = new EchoCommand(args[1]);
//							command.execute();
//						} else {
//							System.out.println("Error");
//						}
//					} else {
//						System.out.println("Error");
//					}
//					break;
//					
//				case "date":
//					if(args.length==2){
//						if(args[1]!=null) {
//							if(args[1].equals("now")){
//								Command command = new DateCommand();
//								command.execute();
//							}else {
//								System.out.println("Error");
//							}
//						} else {
//							System.out.println("Error");
//						}
//					} else{
//						System.out.println("Error");
//					}
//					break;
//					
//				case "exit":
//					if(args.length==1){
//						Command command = new ExitCommand();
//						command.execute();
//					} else {
//						System.out.println("Error");
//					}
//					break;
//					
//					
//				default:
//					System.out.println("Error");
//					break;
//					
//				}
//				
//			} else {
//				System.out.println("Error");
//			}
//			
//		} else {
//			System.out.println("Error");
//		}
		

		
	}
	
	
}
