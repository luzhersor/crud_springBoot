package com.example.crud.repository;

import com.example.crud.model.product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<product, String > {

}
