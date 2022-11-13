package com.alapanoski.chrpr.controller;


import com.alapanoski.chrpr.model.Chrp;
import com.alapanoski.chrpr.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class FeedController {

    @Autowired
    FeedService feedService;

    @GetMapping("/feed")
    public List<Chrp> getFeed() {
        return feedService.getFeed();
    }
}
