package demo.DOMParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DemoDomParser {

    public static void main(String[] args) {
        List<Article> articleList = readFile();
    }
    public static List<Article> readFile(){
        List<Article> articleList = new ArrayList<>();
        String stringUrl = "https://vnexpress.net/rss/tam-su.rss";
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(stringUrl);
            Element element = document.getDocumentElement();
            NodeList nodeList = element.getElementsByTagName("item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Article article = new Article();
                Node itemNode = nodeList.item(i);
                NodeList itemChild = itemNode.getChildNodes();
                for (int j = 0; j < itemChild.getLength(); j++) {
                    switch (itemChild.item(j).getNodeName()) {
                        case "title":
                            article.setTitle(itemChild.item(j).getTextContent());
                            break;
                        case "description":
                            article.setDescription(itemChild.item(j).getTextContent());
                            break;
                        case "pubDate":
                            article.setPubDate(itemChild.item(j).getTextContent());
                            break;
                        case "link":
                            article.setLink(itemChild.item(j).getTextContent());
                            break;
                        case "slash:comments":
                            article.setSlashComments(itemChild.item(j).getTextContent());
                            break;
                    }
                }
                articleList.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleList;
    }
}
