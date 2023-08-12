package com.ders.backend.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DersInputDto {
    String searchWords;

    public String getSearchWords() {
        return searchWords;
    }
}
