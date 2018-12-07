package com.fenghaha.demo_class.DataBean;

/**
 * Created by FengHaHa on2018/12/7 0007 22:16
 */
public class Status {
    private int authorAvatarResId;
    private String authorName;
    private String title;
    private String content;
    private String updateTime;


    public int getAuthorAvatarResId() {
        return authorAvatarResId;
    }

    public void setAuthorAvatarResId(int authorAvatarResId) {
        this.authorAvatarResId = authorAvatarResId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
