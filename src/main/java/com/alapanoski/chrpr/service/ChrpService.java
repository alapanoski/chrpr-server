package com.alapanoski.chrpr.service;

import com.alapanoski.chrpr.model.Chrp;
import com.alapanoski.chrpr.repository.ChrpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ChrpService {

    private final ChrpRepository chrpRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public ChrpService(ChrpRepository chrpRepository) {
        this.chrpRepository = chrpRepository;
    }

    public List<Chrp> getAllChrps() {
        return chrpRepository.findAll();
    }

    public Optional<Chrp> getChrpById(String id) {
        return chrpRepository.findById(id);
    }

    public String postNewChrp(Chrp chrp) {
        chrp.setDate(new Date());
        chrpRepository.save(chrp);
        return chrp.getMessage();
    }

    public List<Chrp> getChrpsByUser(String username) {
        Query query = new Query();
        System.out.println(username);
        query.addCriteria(Criteria.where("username").is(username));
        return mongoTemplate.find(query, Chrp.class);
    }
}
