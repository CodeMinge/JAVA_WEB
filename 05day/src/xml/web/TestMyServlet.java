package xml.web;

import org.junit.Test;

public class TestMyServlet {
//	@Test
//	public void testMyServlet() {
//		MyServlet msl = new MyServlet();
//		msl.init();
//		msl.service();
//		msl.destory();
//	}
	
	@Test
	public void testMyServlet() {
		String className = "xml.web.MyServlet";
		Class clazz;
		try {
			clazz = Class.forName(className);
			MyServlet msl = (MyServlet) clazz.newInstance();
			msl.init();
			msl.service();
			msl.destory();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
