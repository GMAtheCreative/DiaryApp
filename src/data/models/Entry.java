package data.models;

import java.time.LocalDate;

public class Entry {
    private int id;
    private String title;
    private String content;
    private String diaryId;
    private LocalDate entryDate = LocalDate.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }
}


