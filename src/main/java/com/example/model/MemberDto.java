package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String id;
    private String password;
    private String email;
    private String name;
    private String address;
    private String membership;
    private String status;

    // 생성자
    public MemberDto(String id, String password, String email, String name, String address, String membership, String status) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.membership = membership;
        this.status = status;
    }
}
