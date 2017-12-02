package com.cn.Demo1;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;

public class Test1 {
    public static void main(String[] args) {
        URL url = Test1.class.getResource("/Book.xml");
        try {
            DocumentBuilder builder= DocumentBuilderFactory.newInstance().newDocumentBuilder();
            File f=new File(url.getFile());
            if(!f.exists())
            {
                System.out.println("文件找不到！");
            }

            Document doc=builder.parse(f);


            Element root=doc.getDocumentElement();
            NodeList list=root.getElementsByTagName("book");
            System.out.println("list:"+list.getLength());

            for (int i = 0; i < list.getLength(); i++) {
                Element n=(Element)list.item(i);

                //获取属性值
                NamedNodeMap a = n.getAttributes();
                for (int j = 0; j < a.getLength(); j++) {
                    System.out.println(a.item(j).getNodeName()+"="+a.item(j).getNodeValue());
                }

                //获取内部的值：
                Node node=n.getElementsByTagName("title").item(0).getFirstChild();
                System.out.println("值："+node.getNodeValue());

            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
