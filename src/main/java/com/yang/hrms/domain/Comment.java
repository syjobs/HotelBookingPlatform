package com.yang.hrms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunyang
 * @date 2019/12/4
 * 评论信息表
 * 主要记录了用户对已住过的客房的评论
 */
public class Comment implements Serializable{
    //主键id
    private Integer id;
    //评论内容
    private String content;
    //评论时间
    private Date pubDate;
    //评论的酒店
    private RoomInfo roomInfo;
    //发表评论的用户
    private User user;

    public Comment() {
    }

    public Comment(String content, Date pubDate, RoomInfo roomInfo, User user) {
        this.content = content;
        this.pubDate = pubDate;
        this.roomInfo = roomInfo;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(RoomInfo roomInfo) {
        this.roomInfo = roomInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
