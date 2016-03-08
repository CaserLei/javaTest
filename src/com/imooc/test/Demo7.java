package com.imooc.test;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Demo7 {
	/**
	 * 增加：标签，属性
	 * @throws Exception
	 */
	
	public void test1() throws Exception{
		/**
		 * 1.创建一个新的文档
		 */
		Document doc=DocumentHelper.createDocument();
		
		/**
		 * 2.增加标签
		 */
		Element rootElem=doc.addElement("contactList");
		Element contactElem=rootElem.addElement("contact");
		contactElem.addAttribute("id", "001");
		Element nameElem=contactElem.addElement("name");
		nameElem.setText("李明");
		
		//三、把修改后的Document对象写出到xml文件中
		//指定文件输出的对象
		FileOutputStream out=new FileOutputStream("./src/com/imooc/test/contact1.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		//创建写出对象
		XMLWriter writer=new XMLWriter(out);
		
		//2.写出对象
		writer.write(doc);
		
		writer.close();

	}
	/**
	 * 修改：属性值， 文本
	 * @throws Exception
	 */
	
	public void test2() throws Exception{
		Document doc=new SAXReader().read(new File("./src/com/imooc/test/contact1.xml"));
		
		/**
		 * 属性值 1.得到标签对象 2.得到属性对象 3.修改属性值
		 */
		/*
		Element contactElem=doc.getRootElement().element("contact");
		//得到属性的对象
		Attribute idAttr=contactElem.attribute("id");
		idAttr.setValue("003");*/
		
		
		/**
		 * 方案二：修改属性
		 */
		//1.1 得到 标签对象
		/*Element contactElem=doc.getRootElement().element("contact");
		contactElem.addAttribute("id", "004");//通过增加同名属性的方法，修改属性值
*/		
		
		/**
		 * 修改文本 1.得到标签对象 2.修改文本内容  
		 */
		Element nameElem=doc.getRootElement().element("contact").element("name");
		nameElem.setText("我是傻逼！，我是张连新，是国际张");
		
		//三、把修改后的Document对象写出到xml文件中
		//指定文件输出的对象
		FileOutputStream out=new FileOutputStream("./src/com/imooc/test/contact2.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		//创建写出对象
		XMLWriter writer=new XMLWriter(out);
		
		//2.写出对象
		writer.write(doc);
		
		writer.close();
	}
	/**
	 * 删除 ： 标签  属性
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception{
		Document doc=new SAXReader().read(new File("./src/com/imooc/test/contact.xml"));
		
		/**
		 * 删除标签
		 */
		/*Element ageElem=doc.getRootElement().element("contact").element("age");
		//ageElem.detach();
		
		ageElem.getParent().remove(ageElem);*/
		
		/**
		 * 删除属性
		 */
		Element contactElem=(Element)doc.getRootElement().elements().get(1);
		Attribute idAttr=contactElem.attribute("id");
		idAttr.detach();
		
        //idAttr.getParent().remove(idAttr);
		
		FileOutputStream out=new FileOutputStream("./src/com/imooc/test/contact5.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		//创建写出对象
		XMLWriter writer=new XMLWriter(out);
		
		//2.写出对象
		writer.write(doc);
		
		writer.close();
	}

}
