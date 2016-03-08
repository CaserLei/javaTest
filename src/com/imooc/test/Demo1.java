package com.imooc.test;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Demo1 {
   public static void main(String[] args) {
	   try {
		   SAXReader reader=new SAXReader();
		   Document doc=reader.read(new File("./src/com/imooc/test/contact.xml"));
		   System.out.println(doc);
	} catch (DocumentException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
   }
}
