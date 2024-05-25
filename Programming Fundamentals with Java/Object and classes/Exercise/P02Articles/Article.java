package Exercise.P02Articles;

public class Article {
    private String title;
    private String content;
    private String author;



    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public void Edit(String newContent) {
        content = newContent;
    }
    public void ChangeAuthor(String newAuthor) {
        author = newAuthor;
    }
    public void Rename(String newTitle) {
        title = newTitle;
    }
}
