package com.imooc.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 第一个写出内容到xml文档
 * @author Administrator
 *
 */
public class Demo5 {

	public static void main(String[] args) throws Exception {
		//读取xml文件
		Document doc=new SAXReader().read(new File("./src/com/imooc/test/contact.xml"));
		
		//二、修改Document对象的内容
		
		
		//三、把修改后的Document对象写出到xml文件中
		
		
		//指定文件输出的对象
		FileOutputStream out=new FileOutputStream("./src/contact2.xml");
		//创建写出对象
		XMLWriter writer=new XMLWriter(out);
		
		//2.写出对象
		writer.write(doc);
		
		writer.close();

	}

}
