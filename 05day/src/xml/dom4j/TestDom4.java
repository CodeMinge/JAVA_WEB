package xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestDom4 {
	@Test
	public void testReadWebXml() {
		SAXReader saxReader = new SAXReader();
		try {
			Document doc = saxReader.read("src/xml/schema/web.xml");
			Element ele = doc.getRootElement();
			//System.out.println(ele.getName());
			//System.out.println(ele.attributeValue("version"));
			List<Element> le = ele.elements();
			for(Element element:le) {
				if("servlet".equals(element.getName())) {
					Element servletName = element.element("servlet-name");
					Element servletClass = element.element("servlet-class");
					System.out.println(servletName.getText());
					System.out.println(servletClass.getText());
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
