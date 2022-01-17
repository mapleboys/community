package com.example.communication.model;

public class Question {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.id
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.title
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.gmt_create
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.gmt_modified
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.creator
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private Integer creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.comment_account
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private Integer commentAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.view_account
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private Integer viewAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.like_account
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private Integer likeAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.tag
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private String tag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.description
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Question(Integer id, String title, Long gmtCreate, Long gmtModified, Integer creator, Integer commentAccount, Integer viewAccount, Integer likeAccount, String tag) {
        this.id = id;
        this.title = title;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.creator = creator;
        this.commentAccount = commentAccount;
        this.viewAccount = viewAccount;
        this.likeAccount = likeAccount;
        this.tag = tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Question(Integer id, String title, Long gmtCreate, Long gmtModified, Integer creator, Integer commentAccount, Integer viewAccount, Integer likeAccount, String tag, String description) {
        this.id = id;
        this.title = title;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.creator = creator;
        this.commentAccount = commentAccount;
        this.viewAccount = viewAccount;
        this.likeAccount = likeAccount;
        this.tag = tag;
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Question() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.id
     *
     * @return the value of question.id
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.id
     *
     * @param id the value for question.id
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.title
     *
     * @return the value of question.title
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.title
     *
     * @param title the value for question.title
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.gmt_create
     *
     * @return the value of question.gmt_create
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.gmt_create
     *
     * @param gmtCreate the value for question.gmt_create
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.gmt_modified
     *
     * @return the value of question.gmt_modified
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.gmt_modified
     *
     * @param gmtModified the value for question.gmt_modified
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.creator
     *
     * @return the value of question.creator
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.creator
     *
     * @param creator the value for question.creator
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.comment_account
     *
     * @return the value of question.comment_account
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Integer getCommentAccount() {
        return commentAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.comment_account
     *
     * @param commentAccount the value for question.comment_account
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setCommentAccount(Integer commentAccount) {
        this.commentAccount = commentAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.view_account
     *
     * @return the value of question.view_account
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Integer getViewAccount() {
        return viewAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.view_account
     *
     * @param viewAccount the value for question.view_account
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setViewAccount(Integer viewAccount) {
        this.viewAccount = viewAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.like_account
     *
     * @return the value of question.like_account
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public Integer getLikeAccount() {
        return likeAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.like_account
     *
     * @param likeAccount the value for question.like_account
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setLikeAccount(Integer likeAccount) {
        this.likeAccount = likeAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.tag
     *
     * @return the value of question.tag
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.tag
     *
     * @param tag the value for question.tag
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.description
     *
     * @return the value of question.description
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.description
     *
     * @param description the value for question.description
     *
     * @mbg.generated Mon Jan 17 20:36:29 CST 2022
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}