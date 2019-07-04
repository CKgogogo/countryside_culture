package com.countryside_culture.entity;

public class troupe {
    private Integer troupeId;

    private String troupeName;

    private String member;

    private String remark;

    private String content;

    public Integer getTroupeId() {
        return troupeId;
    }

    public void setTroupeId(Integer troupeId) {
        this.troupeId = troupeId;
    }

    public String getTroupeName() {
        return troupeName;
    }

    public void setTroupeName(String troupeName) {
        this.troupeName = troupeName == null ? null : troupeName.trim();
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member == null ? null : member.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}