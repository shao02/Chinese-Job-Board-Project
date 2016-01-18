package com.chinese.jobs.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long userId;

    @Column(name="user_account_name")
    private String userAccountName;

    @Column(name="user_account_password")
    private String userAccountPassword;

    @OneToMany(mappedBy="jobUser", cascade = CascadeType.REMOVE)
    private List<Job> jobs;

    @OneToMany(mappedBy="user", cascade = CascadeType.REMOVE)
    private List<UserToken> tokens;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAccountName() {
        return userAccountName;
    }

    public void setUserAccountName(String userAccountName) {
        this.userAccountName = userAccountName;
    }

    public String getUserAccountPassword() {
        return userAccountPassword;
    }

    public void setUserAccountPassword(String userAccountPassword) {
        this.userAccountPassword = userAccountPassword;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<UserToken> getTokens() {
        return tokens;
    }

    public void setTokens(List<UserToken> tokens) {
        this.tokens = tokens;
    }

    public User(String userAccountPassword, String userAccountName) {
        this.userAccountPassword = userAccountPassword;
        this.userAccountName = userAccountName;
    }

    public User(){}
}
