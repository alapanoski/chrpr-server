package com.alapanoski.chrpr.service;

import com.alapanoski.chrpr.model.Chrp;
import com.alapanoski.chrpr.model.User;
import com.alapanoski.chrpr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUserByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mongoTemplate.find(query, User.class);
    }

    public String getUserDisplayNameByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        List<User> user = mongoTemplate.find(query, User.class);
        return user.get(0).getFirst_name() + ' ' + user.get(0).getLast_name();
    }

    public String addNewUser(User user) {
        user.setDateOfRegistration(new Date());
        userRepository.save(user);
        return user.toString();
    }

    public List<Chrp> getChrpsByUser(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mongoTemplate.find(query, Chrp.class);
    }
}
