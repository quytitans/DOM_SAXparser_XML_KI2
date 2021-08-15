package demo.Model;

import demo.DOMParser.Article;
import demo.Util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleModel {
    public static void saveArticle(Article article) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO article002 ");
            stringBuilder.append("(title, description, pubDate, link, slashComments)");
            stringBuilder.append("VALUES (?,?,?,?,?)");
            PreparedStatement preparedStatement = cnn.prepareStatement(stringBuilder.toString());
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getDescription());
            preparedStatement.setString(3, article.getPubDate());
            preparedStatement.setString(4, article.getLink());
            preparedStatement.setString(5, article.getSlashComments());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
