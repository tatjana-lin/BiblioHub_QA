package com.bibliotheque_API.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class UserUpdateDto {

    private int id;
    private String email;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String number;
    private String zip;
    private String phone;
    private boolean active;

}
