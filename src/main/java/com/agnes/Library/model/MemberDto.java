package com.agnes.Library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class MemberDto {
    private int pesel;
    private int phoneNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
