package com.cn.Demo1;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        URL url = Test1.class.getResource("/Book.xml");
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(url);
            Element root=document.getRootElement();
            List list=root.elements();
            for (int i = 0; i <list.size(); i++) {
                Element node= ((Element)list.get(i));
                //获取属性值：
                System.out.println("name:"+node.attribute(0).getName());
                System.out.println("value:"+node.attribute(0).getValue());
                //获取节点的节点
                List books=node.elements();
                for (int j = 0; j < books.size(); j++) {
                    Element e=(Element)books.get(j);
                    System.out.println("title:"+e.getName());;
                    System.out.println("author:"+e.getText());;
                }

                System.out.println("--------------------");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
