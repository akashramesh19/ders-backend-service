package com.ders.backend.services;

import com.ders.backend.configs.JesiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DersServiceImpl implements DersService{

    @Autowired
    JesiConfig jesi;
    List<String> wordList = new ArrayList<>(Arrays.asList(" for "," in "," the "," a "," on "," at "," of "));

    String cleanedWords;

    @Override
    public Map<String,Double> searchResume(String searchWords){
        cleanedWords = searchWords;
        for(String word:wordList){
            cleanedWords = cleanedWords.replace(word," ");
        }
        return jesi.searchJesi(cleanedWords);
    }

    @Override
    public String indexFiles(String filePath) {
        jesi = new JesiConfig(filePath);
        return "Files Indexed";
    }
}
