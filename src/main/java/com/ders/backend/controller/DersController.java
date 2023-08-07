package com.ders.backend.controller;

import com.ders.backend.dto.DersInputDto;
import com.ders.backend.services.DersServiceImpl;
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

    @PostMapping("/search")
    public ResponseEntity<TreeMap<String,String>> searchTokens(@RequestBody DersInputDto dersInputDto){
        try{
            dersService.searchResume(dersInputDto.getSearchWords());
            return new ResponseEntity<>(new TreeMap<>(),HttpStatus.OK);
        }catch (RuntimeException runtimeException){
            return new ResponseEntity<>(new TreeMap<>(),HttpStatus.BAD_GATEWAY);
        }
    }

}
