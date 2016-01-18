package com.chinese.jobs.model;

import com.chinese.jobs.filter.Authenticate;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.persistence.*;

/**
 * Created by xu_s on 1/17/16.
 */

@Entity
@Table(name="USERTOKEN")
public class UserToken {
    @Id
    @GeneratedValue
    @Column(name="token_id")
    private Long tokenId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public UserToken(User user) {
        this.user = user;
    }

    public UserToken(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getRawUserToken(){
        return Jwts.builder()
                   .setPayload("{\"Name\":\"lalee\"UserToken}")
                   .signWith(SignatureAlgorithm.HS512, Authenticate.key)
                   .compact();
    }
}
