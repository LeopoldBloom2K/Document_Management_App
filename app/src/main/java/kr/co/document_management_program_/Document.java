package kr.co.document_management_program_;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "documents")
public class Document {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String content;

    // 기본 생성자
    public Document() {}

    // title 과 content 를 인자로 받는 생성자
    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

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

    // 제목과 내용이 모두 비어 있는지 확인하는 메서드
    public boolean isEmpty() {
        return title == null || title.trim().isEmpty() || content == null || content.trim().isEmpty();
    }
}
