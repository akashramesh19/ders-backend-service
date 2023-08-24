package com.ders.backend.controller;

import com.ders.backend.dto.DersInputDto;
import com.ders.backend.services.DersServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
@RequestMapping("/ders")
public class DersController {

    @Autowired
    DersServiceImpl dersService;

    Logger logger = LogManager.getLogger(DersController.class);

    @PostMapping("/search")
    public ResponseEntity<TreeMap<String,String>> searchTokens(@RequestBody DersInputDto dersInputDto){
        try{
            logger.info("DERS received the following user input: {}",dersInputDto.getSearchWords());
            String cleanedWords = dersService.searchResume(dersInputDto.getSearchWords());
            logger.info("DERS is calling JESI to search for the following words");
            return new ResponseEntity<>(new TreeMap<>(),HttpStatus.OK);
        }catch (RuntimeException runtimeException){
            return new ResponseEntity<>(new TreeMap<>(),HttpStatus.BAD_GATEWAY);
        }
    }

}
