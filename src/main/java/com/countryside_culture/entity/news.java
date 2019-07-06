package com.countryside_culture.entity;

public class news {
    private Integer id;

    private String title;//标题

    private String author;//来源、作者

    private String publishTime;//发布时间

    private String picture;//图片路径

    private Integer isHot;//是否热门

    private Integer isPublish;//是否发布

    private Integer clickNum;//点击量

    private Integer examStatus;

    private String expansion1;

    private String expansion2;

    private String content;

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
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime == null ? null : publishTime.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }

    public String getExpansion1() {
        return expansion1;
    }

    public void setExpansion1(String expansion1) {
        this.expansion1 = expansion1 == null ? null : expansion1.trim();
    }

    public String getExpansion2() {
        return expansion2;
    }

    public void setExpansion2(String expansion2) {
        this.expansion2 = expansion2 == null ? null : expansion2.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}