package com.example.blueoptima.Repository;

import com.example.blueoptima.Data.LogData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends MongoRepository<LogData,String> {
}
