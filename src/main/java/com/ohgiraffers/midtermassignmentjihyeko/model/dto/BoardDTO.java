package com.ohgiraffers.midtermassignmentjihyeko.model.dto;

import java.io.Serializable;

public class BoardDTO implements Serializable {
    /*  DTO의 5요소
    *  1. 필드
    *  2. 생성자
    *  3. Getter/Setter
    *  4. ToString
    *  5. 직렬화(Serializable)*/

    private String title;
    private String content;
    private MemberDTO writer;
    private FileDTO attachedFile;

    public BoardDTO() {
    }

    public BoardDTO(String title, String content, MemberDTO writer, FileDTO attachedFile) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.attachedFile = attachedFile;
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

    public MemberDTO getWriter() {
        return writer;
    }

    public void setWriter(MemberDTO writer) {
        this.writer = writer;
    }

    public FileDTO getAttachedFile() {
        return attachedFile;
    }

    public void setAttachedFile(FileDTO attachedFile) {
        this.attachedFile = attachedFile;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", attachedFile=" + attachedFile +
                '}';
    }
}
