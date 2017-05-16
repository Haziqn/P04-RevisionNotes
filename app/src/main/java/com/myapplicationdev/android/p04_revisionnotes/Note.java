package com.myapplicationdev.android.p04_revisionnotes;

public class Note {
    Integer id;
    String noteContent;
    Integer star;

    public Note(Integer id, String noteContent, Integer star) {
        this.id = id;
        this.noteContent = noteContent;
        this.star = star;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Integer getStar() {
        return star;
    }

    public void setStars(Integer star) {
        star = star;
    }
}
