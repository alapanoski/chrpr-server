package com.alapanoski.chrpr.service;

import com.alapanoski.chrpr.model.Chrp;
import com.alapanoski.chrpr.model.User;
import com.alapanoski.chrpr.repository.ChrpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {

    private final ChrpRepository chrpRepository;

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserService userService;

    public FeedService(ChrpRepository chrpRepository) {
        this.chrpRepository = chrpRepository;
    }

    public List<Chrp> getFeed() {
        List<Chrp> chrps = chrpRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
        for (Chrp chrp : chrps) {
            User user = userService.getUserByUsername(chrp.getUsername()).get(0);
            String display_name = user.getFirst_name() + ' ' + user.getLast_name();
            chrp.setDisplay_name(display_name);
        }
        return chrps;
    }

}
