package Diary.data.models;

import java.time.LocalDate;

public class Entry {
    private String title;
    private String content;
    private LocalDate date = LocalDate.now();
    private long id;
    User userid;

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Entry(String title, String content) {
        this.title = title;
        this.content = content;
    }

//    setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setId(long id) {
        this.id = id;
    }

//    getters
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public LocalDate getDate() {
        return date;
    }
    public long getId() {
        return id;
    }

}
