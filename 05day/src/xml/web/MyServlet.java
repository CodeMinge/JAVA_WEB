package xml.web;

public class MyServlet implements IMyServlet {

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("1、初始化");
	}

	public void service() {
		// TODO Auto-generated method stub
		System.out.println("2、服务");
	}

	public void destory() {
		// TODO Auto-generated method stub
		System.out.println("3、销毁");
	}

}
