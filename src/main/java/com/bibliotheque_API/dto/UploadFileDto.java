package com.bibliotheque_API.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class UploadFileDto {

    private String filePath;

}
