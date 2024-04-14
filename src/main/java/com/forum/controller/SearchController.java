package com.forum.controller;

import com.forum.dtos.PostResDto;
import com.forum.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    ResponseEntity<List<PostResDto>> getPostMatching(@RequestParam String searchText){
        List<PostResDto> postResDtoList = searchService.getAllPosts(searchText);
        return new ResponseEntity<>(postResDtoList, HttpStatus.OK);
    }

    @GetMapping("/index")
    ResponseEntity<String> doInitialIndexing(){
        try {
            searchService.createIndex();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error occured !!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Initial Indexing done", HttpStatus.CREATED);
    }

}
