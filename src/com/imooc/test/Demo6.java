package com.imooc.test;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo6 {
	public static void main(String[] args) throws Exception {
		//读取xml文件
		Document doc=new SAXReader().read(new File("./src/com/imooc/test/contact.xml"));
		
		/**
		 * 指定写出的格式
		 */
		//OutputFormat format=OutputFormat.createCompactFormat();//紧凑的格式
		OutputFormat format=OutputFormat.createPrettyPrint();//漂亮的格式
		//二、修改Document对象的内容
		
		
		//三、把修改后的Document对象写出到xml文件中
		
		/**
		 * 2.指定生成xml文档的编码
		 */
		format.setEncoding("utf-8");
		//指定文件输出的对象
		FileOutputStream out=new FileOutputStream("./src/contac4.xml");
		//创建写出对象
		XMLWriter writer=new XMLWriter(out,format);
		
		//2.写出对象
		writer.write(doc);
		
		writer.close();
	}

}
