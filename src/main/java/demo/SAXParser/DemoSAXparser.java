package demo.SAXParser;

import demo.DOMParser.Article;
import demo.Model.ArticleModel;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

public class DemoSAXparser {

    public static void main(String[] args) {
        List<Article> articleList = readFile("https://vnexpress.net/rss/tam-su.rss");
        for (Article article : articleList
        ) {
            ArticleModel.saveArticle(article);
        }
    }

    public static List<Article> readFile(String url) {
        List<Article> articleList = null;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser;
            saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(url, userhandler);
            articleList = userhandler.getArticleList();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleList;
    }
}
