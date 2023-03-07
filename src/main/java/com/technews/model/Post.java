package com.technews.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="post")

public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String postUrl;
    @Transient
    private String username;
    @Transient
    private int voteCount;
    private Integer userId;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "posted_at")
    private Date postedAt = new Date();
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt = new Date();
    // Need to use FetchType.LAZY to resolve multiple bags exception
    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public Post() {
    }

    public Post(Integer id, String title, String postUrl, String username, int voteCount, Integer userId, Date postedAt, Date updatedAt, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.postUrl = postUrl;
        this.username = username;
        this.voteCount = voteCount;
        this.userId = userId;
        this.postedAt = postedAt;
        this.updatedAt = updatedAt;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return voteCount == post.voteCount && Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(postUrl, post.postUrl) && Objects.equals(username, post.username) && Objects.equals(userId, post.userId) && Objects.equals(postedAt, post.postedAt) && Objects.equals(updatedAt, post.updatedAt) && Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, postUrl, username, voteCount, userId, postedAt, updatedAt, comments);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", username='" + username + '\'' +
                ", voteCount=" + voteCount +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                '}';
    }

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

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
