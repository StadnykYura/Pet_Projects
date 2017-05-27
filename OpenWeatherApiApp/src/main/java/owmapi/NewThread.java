package owmapi;



public class NewThread implements Runnable{
	private String url;
	private URLconnect target;
	public	Thread t;
	private StringBuffer result;
	
	public NewThread(URLconnect target, String url) {
		this.url = url;
		this.target = target;
		t = new Thread(this);
		t.start();
	}
	
	
	public void run() {
		
		try {
			this.result = target.sendGet(url);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}


	public StringBuffer getResult() {
		return result;
	}

	
	
}
