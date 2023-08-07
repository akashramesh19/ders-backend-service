package com.ders.backend.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DersServiceImpl implements DersService{

    List<String> wordList = new ArrayList<>(Arrays.asList(" for "," in "," the "," a "," on "," at "," of "));

    String cleanedWords;

    @Override
    public String searchResume(String searchWords){
        try{
            cleanedWords = searchWords;
            for(String word:wordList){
                cleanedWords = cleanedWords.replace(word," ");
                System.out.println(word);
            }
            return cleanedWords;
        }catch(RuntimeException runtimeException){
            return "Runtime Exception has occured";
        }
    }
}
