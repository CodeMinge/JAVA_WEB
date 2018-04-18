package xml.web2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

public class TestMyServlet2 {
	//8.鍒涘缓涓�涓猰ap闆嗗悎
	private HashMap<String, String> data = new HashMap<String,String>();
	
	@Before
	public void testReadWEBXml(){
		try {
			//1.鍒涘缓瑙ｆ瀽鍣ㄥ璞�
			SAXReader saxReader = new SAXReader();
			//2.浣跨敤瑙ｆ瀽鍣ㄥ姞杞絯eb.xml鏂囦欢寰楀埌document瀵硅薄
			Document document = saxReader.read("src/xml/web2/web.xml");
			//3.鑾峰彇鏍瑰厓绱犺妭鐐�
			Element rootElement = document.getRootElement();
			//4.鑾峰彇瀛愯妭鐐�(servlet鍜宻ervlet-mapping)
			List<Element> childElements = rootElement.elements();
			//5.閬嶅巻
			for (Element element : childElements) {
				//6.鍒ゆ柇鍏冪礌鐨勫悕绉颁负servlet鐨勫厓绱犺妭鐐�
				if("servlet".equals(element.getName())){
					//7.鍒嗗埆鑾峰彇servlet鍏冪礌鑺傜偣鐨剆ervlet-name鍜宻ervlet-class鐨勫��
					String servletName = element.element("servlet-name").getText();
					String servletClass = element.element("servlet-class").getText();
					/*System.out.println(servletName);
					System.out.println(servletClass);*/
					data.put(servletName, servletClass);
				}
				//9.鍒ゆ柇鍏冪礌鐨勫悕绉颁负servlet-mapping鐨勫厓绱犺妭鐐�
				if("servlet-mapping".equals(element.getName())){
					//10.鍒嗗埆鑾峰彇servlet鍏冪礌鑺傜偣鐨剆ervlet-name鍜宻ervlet-class鐨勫��
					String servletName = element.element("servlet-name").getText();
					String urlPattern = element.element("url-pattern").getText();
					//11.灏唖ervletName浣滀负key鏉ヨ幏鍙杝ervletClass鐨勫��
					String servletClass = data.get(servletName);
					//12.灏唘rl-pattern浣滀负key,servletClass浣滀负value瀛樺埌map涓幓
					data.put(urlPattern, servletClass);
					//13.绉婚櫎servletName
					data.remove(servletName);
				}
			}
			//System.out.println(data);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMyServlet(){
		try {
			//1.妯℃嫙鍦ㄦ祻瑙堝櫒杈撳叆涓�涓猽rl
			String url1 = "/myServlet2";
			//2.灏唘rlPattern浣滀负key鏉ヨ幏鍙杝ervletClass
			String className = data.get(url1);
			//3.閫氳繃servletClass鑾峰彇瀛楄妭鐮佹枃浠�
			Class clazz = Class.forName(className);
			//4.閫氳繃瀛楄妭鐮佹枃浠跺垱寤哄疄渚嬪璞�
			Object obj = clazz.newInstance();
			//5.閫氳繃瀛楄妭鐮佹枃浠惰幏鍙栨柟娉�(涓や釜鍙傛暟锛氱涓�涓槸鏂规硶鍚嶇О锛涚浜屼釜鍙傛暟鏄柟娉曠殑鍙傛暟)
			Method method = clazz.getMethod("service", null);
			//6.璋冪敤invoke鏂规硶鎵ц瀹炰緥瀵硅薄閲岄潰鐨勬柟娉�(鍓嶉潰鍐欑殑鏂规硶init)銆愪袱涓弬鏁帮細绗竴涓槸璋冪敤鏂规硶鐨勫疄渚嬪璞★紝绗簩涓槸鏂规硶鐨勫疄鍙傘��
			method.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
