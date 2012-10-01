package jp.itacademy.samples.web.mbbs;

import java.util.Date;

public class Message {

    private String poster;
    private String body;
    private Date postedAt;

    public Message(String poster, String body, Date postedAt) {
        this.poster = poster;
        this.body = body;
        this.postedAt = postedAt;
    }

    public String getPoster() {
        return poster;
    }

    public String getBody() {
        return body;
    }

    public Date getPostedAt() {
        return postedAt;
    }

}
