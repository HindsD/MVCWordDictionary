package edu.wctc.mvcworddictionary.service;

import edu.wctc.mvcworddictionary.entity.Word;

import java.util.List;

public interface WordListService {
    String getWord(String word);
    List<Word> getWords();
}
