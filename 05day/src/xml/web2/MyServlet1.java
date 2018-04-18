package xml.web2;

public class MyServlet1 implements IMyServlet{

	public void init() {
		System.out.println("MyServlet1璇炵敓浜嗏�︹��");
	}

	public void service() {
		System.out.println("MyServlet1寮�濮嬫湇鍔′簡鈥︹��");
	}

	public void destory() {
		System.out.println("MyServlet1閿�姣佷簡鈥︹��");
	}

}
