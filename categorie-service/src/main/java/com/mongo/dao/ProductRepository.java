package com.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mongo.entitie.Product;

@RepositoryRestResource
public interface ProductRepository extends MongoRepository<Product, String>{

}
