package com.ders.backend.controller;

import com.ders.backend.dto.DersInputDto;
import com.ders.backend.services.DersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ders")
public class DersController {

    @Autowired
    DersServiceImpl dersService;

    @PostMapping("/search")
    public ResponseEntity<String> searchTokens(@RequestBody DersInputDto dersInputDto){
        try{
            return new ResponseEntity<>(dersService.searchResume(dersInputDto.getSearchWords()),HttpStatus.OK);
        }catch (RuntimeException runtimeException){
            return new ResponseEntity<>("Runtime Exception has occured",HttpStatus.BAD_GATEWAY);
        }
    }

}
