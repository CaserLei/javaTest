package com.imooc.test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * 练习读取完整的xml文档内容
 * @author Administrator
 *
 */
public class Demo3 {
	
	@Test
	public void test() throws Exception{
		//1.读取xml文档，返回Document对象
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("./src/com/imooc/test/contact.xml"));
		//读取根标签
		
		Element rootElem=doc.getRootElement();
		
		StringBuffer sb=new StringBuffer();
		
		getChildNodes(rootElem,sb);
		
		System.out.println(sb.toString());
	}
	/**
	 * 获取当前标签 的子标签
	 */
	public void getChildNodes(Element elem,StringBuffer sb){
		//System.out.println(elem.getName());
		//开始标签
		sb.append("<"+elem.getName());
		
		//得到标签的属性列表
		List<Attribute> attrs=elem.attributes();
		if(attrs!=null){
			for (Attribute attr : attrs) {
				//System.out.println(attr.getName()+"="+attr.getValue());
				sb.append(" "+attr.getName()+"=\""+attr.getValue()+"\"");
			}
		}
		sb.append(">");
		//String content=elem.getText();
		//System.out.println(content);
		Iterator<Node>it=elem.nodeIterator();
		//遍历
		while(it.hasNext()){
			Node node=it.next();
			//标签
			if(node instanceof Element){
				Element el=(Element)node;
				getChildNodes(el, sb);
			}
			//文本
			if(node instanceof Text){
				Text text=(Text)node;
				sb.append(text.getText());
			}
		}
		
		sb.append("</"+elem.getName()+">");
	}

}
