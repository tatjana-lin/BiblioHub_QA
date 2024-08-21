package com.bibliotheque_API.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.PrimitiveIterator;

@Setter
@Getter
@ToString
@Builder
public class UserRequestDto {

    private String email;
    private String password;
    private String role;


}
