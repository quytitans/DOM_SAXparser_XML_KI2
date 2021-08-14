package demo.DOMParser;

public class Article {
    String title;
    String description;
    String pubDate;
    String link;
    String slashComments;

    public Article() {
    }

    public Article(String title, String description, String pubDate, String link, String slashComments) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
        this.slashComments = slashComments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSlashComments() {
        return slashComments;
    }

    public void setSlashComments(String slashComments) {
        this.slashComments = slashComments;
    }
}
