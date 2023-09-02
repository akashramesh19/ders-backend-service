package com.ders.backend.controller;

import com.ders.backend.dto.DersInputDto;
import com.ders.backend.services.DersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/ders")
public class DersController {

    @Autowired
    DersServiceImpl dersService;

    @PostMapping("/search")
    public ResponseEntity<Map<String,Double>> searchTokens(@RequestBody DersInputDto dersInputDto){
        try{

            return new ResponseEntity<>(dersService.searchResume(dersInputDto.getSearchWords()),HttpStatus.OK);
        }catch (RuntimeException runtimeException){
            return new ResponseEntity<>(new TreeMap<>(),HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/index")
    public ResponseEntity<String>indexFile(@RequestBody DersInputDto dersInputDto)
    {
        String path =dersInputDto.getPath();
        return new ResponseEntity<>(dersService.indexFiles(path), HttpStatus.OK);
    }

}
