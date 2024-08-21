package com.bibliotheque_API.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.management.relation.Role;
import java.util.Set;

@Setter
@Getter
@ToString
@Builder
public class LoginResponseDto {

    private Long id;
    private String accessToken;
    private String refreshToken;
    private String message;
    private Set<Role> role;

}
