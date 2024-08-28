package com.bibliotheque_API.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class BookDto {

    private int id;
    private String title;
    private String authorName;
    private String authorSurname;
    private String year;
    private String isbn;
    private String publisher;
    private int libraryId;
    private int quantity;
    private int available;

}
