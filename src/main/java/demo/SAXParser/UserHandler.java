package demo.SAXParser;

import demo.DOMParser.Article;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class UserHandler extends DefaultHandler {

    private List<Article> articleList = new ArrayList<>();
    private Article article1;
    boolean isTitle;
    boolean isDescription;
    boolean isPubdate;
    boolean isLink;
    boolean isslashComments;

    public List<Article> getArticleList() {
        return articleList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "item":
                article1 = new Article();
                break;
            case "title":
                isTitle = true;
                break;
            case "description":
                isDescription = true;
                break;
            case "pubDate":
                isPubdate = true;
                break;
            case "link":
                isLink = true;
                break;
            case "slash:comments":
                isslashComments = true;
                break;
        }
    }


    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String result = new String(ch, start, length);
        if (isTitle) {
            article1.setTitle(result);
        } else if (isDescription) {
            article1.setDescription(result);
        } else if (isPubdate) {
            article1.setPubDate(result);
        } else if (isLink) {
            article1.setLink(result);
        } else if (isslashComments) {
            article1.setSlashComments(result);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "item":
                articleList.add(article1);
                break;
            case "title":
                isTitle = false;
                break;
            case "description":
                isDescription = false;
                break;
            case "pubDate":
                isPubdate = false;
                break;
            case "link":
                isLink = false;
                break;
            case "slash:comments":
                isslashComments = false;
                break;
        }
    }
}
