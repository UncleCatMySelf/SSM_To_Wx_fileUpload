package com.myself.pojo;

import java.util.Date;

public class Files {
    private Integer id;

    private String msg;

    private String img;

    private Date createTime;

    private Date uploadTime;

    public Files(Integer id, String msg, String img, Date createTime, Date uploadTime) {
        this.id = id;
        this.msg = msg;
        this.img = img;
        this.createTime = createTime;
        this.uploadTime = uploadTime;
    }

    public Files() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}