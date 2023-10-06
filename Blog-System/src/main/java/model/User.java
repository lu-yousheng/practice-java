package model;

public class User {
    private int userId;
    private String username;
    private String password;
    private int blog_count;
    private long avatar;

    public long getAvatar() {
        return avatar;
    }

    public void setAvatar(long avatar) {
        this.avatar = avatar;
    }

    public int getBlog_count() {
        return blog_count;
    }

    public void setBlog_count(int blog_count) {
        this.blog_count = blog_count;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
