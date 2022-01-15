package com.example.communication.model;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_users.id
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_users.account_id
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_users.name
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_users.token
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_users.gmt_create
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_users.gmt_modified
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_users.bio
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    private String bio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_users.avatar_url
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    private String avatarUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public User(Integer id, String accountId, String name, String token, Long gmtCreate, Long gmtModified, String bio, String avatarUrl) {
        this.id = id;
        this.accountId = accountId;
        this.name = name;
        this.token = token;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.bio = bio;
        this.avatarUrl = avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bbs_users
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public User() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_users.id
     *
     * @return the value of bbs_users.id
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_users.id
     *
     * @param id the value for bbs_users.id
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_users.account_id
     *
     * @return the value of bbs_users.account_id
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_users.account_id
     *
     * @param accountId the value for bbs_users.account_id
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_users.name
     *
     * @return the value of bbs_users.name
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_users.name
     *
     * @param name the value for bbs_users.name
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_users.token
     *
     * @return the value of bbs_users.token
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_users.token
     *
     * @param token the value for bbs_users.token
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_users.gmt_create
     *
     * @return the value of bbs_users.gmt_create
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_users.gmt_create
     *
     * @param gmtCreate the value for bbs_users.gmt_create
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_users.gmt_modified
     *
     * @return the value of bbs_users.gmt_modified
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_users.gmt_modified
     *
     * @param gmtModified the value for bbs_users.gmt_modified
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_users.bio
     *
     * @return the value of bbs_users.bio
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public String getBio() {
        return bio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_users.bio
     *
     * @param bio the value for bbs_users.bio
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_users.avatar_url
     *
     * @return the value of bbs_users.avatar_url
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_users.avatar_url
     *
     * @param avatarUrl the value for bbs_users.avatar_url
     *
     * @mbg.generated Sat Jan 15 16:29:10 CST 2022
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }
}