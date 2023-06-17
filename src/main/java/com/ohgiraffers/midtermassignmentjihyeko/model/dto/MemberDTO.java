package com.ohgiraffers.midtermassignmentjihyeko.model.dto;

import java.io.Serializable;

public class MemberDTO implements Serializable {
    private int sequence; //회원 번호
    private String name; //회원 이름
    private String nickname; //회원 닉네임
    private String pwd; //회원 패스워드

    public MemberDTO() {
    }

    public MemberDTO(int sequence, String name, String nickname, String pwd) {
        this.sequence = sequence;
        this.name = name;
        this.nickname = nickname;
        this.pwd = pwd;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "sequence=" + sequence +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
