package xml.web2;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestMyServlet {
	
	@Test
	public void testMyServlet(){
		try {
			//1.鍒涘缓瑙ｆ瀽鍣ㄥ璞�
			SAXReader saxReader = new SAXReader();
			//2.浣跨敤瑙ｆ瀽鍣ㄥ姞杞絯eb.xml鏂囦欢寰楀埌document瀵硅薄
			Document document = saxReader.read("src/xml/web2/web.xml");
			//3.鑾峰彇鏍瑰厓绱犺妭鐐�
			Element rootElement = document.getRootElement();
			//4.鏍规嵁鍏冪礌鍚嶇О鑾峰彇瀛愬厓绱犺妭鐐�
			Element servletElement = rootElement.element("servlet");
			//5.鏍规嵁鍏冪礌鍚嶇О鑾峰彇servlet-class鐨勬枃鏈妭鐐�
			String servletClass = servletElement.element("servlet-class").getText();
			//System.out.println(servletClass);
			//6.閫氳繃绫诲叏鍚嶈幏鍙栧瓧鑺傜爜鏂囦欢
			Class clazz = Class.forName(servletClass);
			//7.鍒涘缓瀹炰緥瀵硅薄
			MyServlet1 my = (MyServlet1) clazz.newInstance();
			//8.璋冪敤瀹炰緥瀵硅薄閲岄潰鐨勬柟娉�
			my.init();
			my.service();
			my.destory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
