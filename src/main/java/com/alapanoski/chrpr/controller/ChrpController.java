package com.alapanoski.chrpr.controller;

import com.alapanoski.chrpr.model.Chrp;
import com.alapanoski.chrpr.service.ChrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ChrpController {

    @Autowired
    ChrpService chrpService;

    @GetMapping("/chrp")
    public List<Chrp> getAllChrps() {
        return chrpService.getAllChrps();
    }

    @GetMapping("/chrp/{id}")
    public Optional<Chrp> getChrpById(@PathVariable String id) {
        return chrpService.getChrpById(id);
    }

    @PostMapping("/chrp")
    public String postNewChrp(@RequestBody Chrp chrp) {
        return chrpService.postNewChrp(chrp);
    }

    @GetMapping("/chrp/user/{username}")
    public List<Chrp> getChrpsByUser(@PathVariable String username) {
        return chrpService.getChrpsByUser(username);
    }
}
