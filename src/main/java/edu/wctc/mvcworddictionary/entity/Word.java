package edu.wctc.mvcworddictionary.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Word {
    private String word;
    private String definition;
}
