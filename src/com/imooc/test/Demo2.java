package com.imooc.test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo2 {
	
	public void test1() throws Exception{
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("./src/com/imooc/test/contact.xml"));
		Iterator<Node> it=doc.nodeIterator();
		while(it.hasNext()){
			Node node=it.next();
			String name=node.getName();
			System.out.println(name);
			
			if(node instanceof Element){
				Element elem=(Element)node;
				Iterator<Node> it2=elem.nodeIterator();
				while(it2.hasNext()){
					Node n2=it2.next();
					System.out.println(n2.getName());
				}
			}
		}
	}
	
	
	public void test2() throws Exception{
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("./src/com/imooc/test/contact.xml"));
		Element rootElement=doc.getRootElement();
		
		getChildNode(rootElement);
	}
	
	public void getChildNode(Element elem){
		System.out.println(elem.getName());
		Iterator<Node> it=elem.nodeIterator();
		while(it.hasNext()){
			Node node=it.next();
			
			//1.判断是否是标签节点   
			if(node instanceof Element){
				Element el=(Element)node;
				getChildNode(el);  //递归
			}
		}
	}
	
	/**
	 * 获取标签
	 * @throws Exception 
	 */
	
	public void test3() throws Exception{
		//1.读取xml文档，返回Document对象
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("./src/com/imooc/test/contact.xml"));
		
		//2.得到跟标签
		Element rootElem=doc.getRootElement();
		//得到标签名称
		String name=rootElem.getName();
		System.out.println(name);
		
		/*//3.得到当前标签下的第一个子标签
		Element contactElem=rootElem.element("contact");
		
		System.out.println(contactElem.getName());*/
		
		//4.得到当前标签下指定名称的所有子标签
		/*Iterator<Element> it=rootElem.elementIterator("contact");
		while(it.hasNext()){
			Element elem=it.next();
			System.out.println(elem.getName());
		}*/
		
		//5.当前标签下的所有子标签
		List<Element> list=rootElem.elements();
		//遍历List的方法
		//1 传统的for循环  2.增强for循环  3.迭代器
		/*for(int i=0;i<list.size();i++){
			Element elem=list.get(i);
			System.out.println(elem.getName());
		}*/
		
		/*for (Element element : list) {
			System.out.println(element.getName());
		}*/
		/*
		Iterator<Element> it = list.iterator();
		while(it.hasNext()){
			Element elem=it.next();
			System.out.println(elem.getName());
		}*/
		
		//获取更深层次的标签（方法只能一层层地获取）
		//doc.getRootElement().elements().get(1);
		
		Element nameElem=doc.getRootElement().element("contact").element("name");
		System.out.println(nameElem.getName());
	}
	
	/**
	 * 获取属性
	 * @throws Exception
	 */
	
	public void test4() throws Exception{
		//1.读取xml文档，返回Document对象
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("./src/com/imooc/test/contact.xml"));
		
		//获取属性：（先获得属性所在的标签对象，然后获取才能获取属性
		//1.得到标签对象
		Element contactElem=doc.getRootElement().element("contact");
		/*//2.得到属性
		//2.1 得到指定名称的属性值
		String idValue=contactElem.attributeValue("id");
		System.out.println(idValue);*/
		
		/*//2.2 得到属性对象
		Attribute idAttr=contactElem.attribute("id");
		//getName： 属性名称  getValue
		System.out.println(idAttr.getName() +"="+idAttr.getValue());*/
		
		//2.3 得到属性对象
		/*List<Attribute> list=contactElem.attributes();
        for (Attribute attr: list) {
			
		}*/
		
		Iterator<Attribute> it=contactElem.attributeIterator();
		while(it.hasNext()){
			Attribute attr=it.next();
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
	}
	
	/**
	 * 获取文本内容
	 * @throws Exception 
	 */
	@Test
	public void test5() throws Exception{
		//1.读取xml文档，返回Document对象
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("./src/com/imooc/test/contact.xml"));
		//获取文本（先获取标签，再获取标签上的文本）
		Element nameElement=doc.getRootElement().element("contact").element("name");
		
		//得到文本
        String text=nameElement.getText();
        System.out.println(text);
        
        
        String text2=doc.getRootElement().element("contact").elementText("name");
        System.out.println(text2);
		
	}

}
