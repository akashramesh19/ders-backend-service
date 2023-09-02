package com.ders.backend.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DersInputDto {
    String searchWords;
    String path;

    public String getSearchWords() {
        return searchWords;
    }
    public String getPath(){return path;}
}
