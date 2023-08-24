package com.ders.backend.services;

import com.ders.backend.controller.DersController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DersServiceImpl implements DersService{

    Logger logger = LogManager.getLogger(DersServiceImpl.class);

    List<String> wordList = new ArrayList<>(Arrays.asList(" for "," in "," the "," a "," on "," at "," of "));

    String cleanedWords;

    @Override
    public String searchResume(String searchWords){
        try{
            logger.info("DERS is cleaning the user input");
            cleanedWords = searchWords;
            for(String word:wordList){
                cleanedWords = cleanedWords.replace(word," ");
            }
            return cleanedWords;
        }catch(RuntimeException runtimeException){
            return "Runtime Exception has occured";
        }
    }
}
