package com.test.pojo;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName: Post
 * @Description: 帖子详情类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/15 10:00
 */
public class Post {
    private Integer pid;
    private String pname;
    private String pcontent;
    private Integer praise;
    private Timestamp pcreate;
    private Timestamp pmodified;
    private String postImg;

    private Integer tid;
    private Topic topic;

    private Integer uid;
    private User user;

    private Integer rid;
    private List<PostReply> postReply;



    public Post() {
    }

    public Post(Integer pid, String pname, String pcontent, Integer tid, Integer praise, Timestamp pcreate, Timestamp pmodified, Integer uid, String postImg, Integer rid) {
        this.pid = pid;
        this.pname = pname;
        this.pcontent = pcontent;
        this.tid = tid;
        this.praise = praise;
        this.pcreate = pcreate;
        this.pmodified = pmodified;
        this.uid = uid;
        this.postImg = postImg;
        this.rid = rid;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public List<PostReply> getPostReply() {
        return postReply;
    }

    public void setPostReply(List<PostReply> postReply) {
        this.postReply = postReply;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Timestamp getPcreate() {
        return pcreate;
    }

    public void setPcreate(Timestamp pcreate) {
        this.pcreate = pcreate;
    }

    public Timestamp getPmodified() {
        return pmodified;
    }

    public void setPmodified(Timestamp pmodified) {
        this.pmodified = pmodified;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }


    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pcontent='" + pcontent + '\'' +
                ", praise=" + praise +
                ", pcreate=" + pcreate +
                ", pmodified=" + pmodified +
                ", postImg='" + postImg + '\'' +
                ", tid=" + tid +
                ", topic=" + topic +
                ", uid=" + uid +
                ", user=" + user +
                ", rid=" + rid +
                ", postReply=" + postReply +
                '}';
    }
}
