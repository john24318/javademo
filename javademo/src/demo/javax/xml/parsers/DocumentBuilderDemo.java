package demo.javax.xml.parsers;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DocumentBuilderDemo {

    public static Document parse(String uri) {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document document = null;

        dbf = DocumentBuilderFactory.newInstance();
        // dbf.setIgnoringElementContentWhitespace(true);// 去除内容中多余的空格
        try {
            db = dbf.newDocumentBuilder();
            document = db.parse(uri);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

    public static void print(Node node) {
        int type = node.getNodeType();

        switch (type) {
            // 根节点
            case Node.DOCUMENT_NODE: {
                Document document = (Document) node;

                System.out.println("<?xml version=\"" + document.getXmlVersion() + "\" ?>");
                print(document.getDocumentElement());
                break;
            }

                // 子节点
            case Node.ELEMENT_NODE: {
                System.out.print("<");
                System.out.print(node.getNodeName()); // 节点名

                // 节点属性
                NamedNodeMap attrs = node.getAttributes();
                for (int i = 0; i < attrs.getLength(); i++)
                    print(attrs.item(i));

                System.out.print(">");

                // 子节点
                if (node.hasChildNodes()) {
                    NodeList children = node.getChildNodes();
                    for (int i = 0; i < children.getLength(); i++)
                        print(children.item(i));
                }

                // 结束符
                System.out.print("</");
                System.out.print(node.getNodeName());
                System.out.print('>');

                break;
            }

                // 属性节点
            case Node.ATTRIBUTE_NODE: {
                System.out.print(" " + node.getNodeName() + "=\"" + ((Attr) node).getValue() + "\"");
                break;
            }

                // 文本节点
            case Node.TEXT_NODE: {
                System.out.print(node.getNodeValue());
                break;
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        URL uri = DocumentBuilderDemo.class.getResource("build.xml");

        long time1 = System.currentTimeMillis();
        Document document = parse(uri.toString());
        long time2 = System.currentTimeMillis();
        // print(document);
        NodeList list = document.getElementsByTagName("target");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            NamedNodeMap map = node.getAttributes();
            String name = map.getNamedItem("name").getNodeValue();
            String description = (null == map.getNamedItem("description")) ? "" : map.getNamedItem("description").getNodeValue();
            System.out.printf("%-45s%s\n", name, description);
        }
        long time3 = System.currentTimeMillis();

        System.out.println("\nParse xml spent " + (time2 - time1) + " ms");
        System.out.println("Print xml spent " + (time3 - time2) + " ms");
    }

}
