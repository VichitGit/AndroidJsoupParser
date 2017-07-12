package jsoup.vichit.com.jsoupparser.model;

/**
 * Created by VichitDeveloper on 7/11/17.
 */

public class CinemaModel {


    public CinemaModel(String title, String imageUrl, String link) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.link = link;
    }

    private String title;
    private String imageUrl;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public String toString() {
        return "CinemaModel{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
