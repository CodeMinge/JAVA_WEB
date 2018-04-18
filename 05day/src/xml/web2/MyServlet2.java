package xml.web2;

public class MyServlet2 implements IMyServlet{

	public void init() {
		System.out.println("MyServlet2璇炵敓浜嗏�︹��");
	}

	public void service() {
		System.out.println("MyServlet2寮�濮嬫湇鍔′簡鈥︹��");
	}

	public void destory() {
		System.out.println("MyServlet2閿�姣佷簡鈥︹��");
	}

}
