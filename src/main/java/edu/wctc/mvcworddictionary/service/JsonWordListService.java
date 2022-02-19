package edu.wctc.mvcworddictionary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wctc.mvcworddictionary.entity.Word;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonWordListService implements WordListService {
    private List<Word> wordList;


    @Override
    public List<Word> getWords(){
        return wordList;
    }

    @PostConstruct
    public void initWords(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Word[] wordArray = mapper.readValue(Paths.get("words.json").toFile(), Word[].class);
            wordList = Arrays.asList(wordArray);
        }
        catch (IOException e) {
            e.printStackTrace();
            wordList = new ArrayList<>(0);
        }
    }
    public String getWord(String word){
        for (Word item: wordList){
            if(item.getWord().equalsIgnoreCase(word)){
                return item.getDefinition();
            }
        }
        return "No definition for this word";
    }



}
