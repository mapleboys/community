package com.example.communication.model;

public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentAccount;
    private Integer viewAccount;
    private Integer likeAccount;
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getCommentAccount() {
        return commentAccount;
    }

    public void setCommentAccount(Integer commentAccount) {
        this.commentAccount = commentAccount;
    }

    public Integer getViewAccount() {
        return viewAccount;
    }

    public void setViewAccount(Integer viewAccount) {
        this.viewAccount = viewAccount;
    }

    public Integer getLikeAccount() {
        return likeAccount;
    }

    public void setLikeAccount(Integer likeAccount) {
        this.likeAccount = likeAccount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", creator=" + creator +
                ", commentAccount=" + commentAccount +
                ", viewAccount=" + viewAccount +
                ", likeAccount=" + likeAccount +
                ", tag='" + tag + '\'' +
                '}';
    }
}
