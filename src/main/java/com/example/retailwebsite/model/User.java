package com.example.retailwebsite.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="hascard")
    private boolean hascard;

    @Column(name="cardType")
    private String cardType;

    @Column(name="affiliated")
    private boolean affiliated;

    @Column(name="createDate")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date createDate;

    public User() {
    }
    public User( String name, String password, boolean hascard, String cardType, boolean affiliated, Date createDate) {

        this.name = name;
        this.password = password;
        this.hascard = hascard;
        this.cardType = cardType;
        this.affiliated = affiliated;
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHascard() {
        return hascard;
    }

    public void setHascard(boolean hascard) {
        this.hascard = hascard;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public boolean isAffiliated() {
        return affiliated;
    }

    public void setAffiliated(boolean affiliated) {
        this.affiliated = affiliated;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", hascard=" + hascard +
                ", cardType='" + cardType + '\'' +
                ", affiliated=" + affiliated +
                ", createDate=" + createDate +
                '}';
    }
}

