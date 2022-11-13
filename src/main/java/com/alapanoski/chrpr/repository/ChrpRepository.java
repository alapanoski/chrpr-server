package com.alapanoski.chrpr.repository;

import com.alapanoski.chrpr.model.Chrp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChrpRepository extends MongoRepository<Chrp, String> {
}
