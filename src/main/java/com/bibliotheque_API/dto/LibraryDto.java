package com.bibliotheque_API.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class LibraryDto {

    private String id;
    private String name;
    private String country;
    private String city;
    private String street;
    private String number;
    private String zip;
    private String phone;
    private String librarian_id;

}
