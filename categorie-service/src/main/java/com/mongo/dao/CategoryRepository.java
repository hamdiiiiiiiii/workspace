package com.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mongo.entitie.Category;

@RepositoryRestResource
public interface CategoryRepository extends MongoRepository<Category, String>{

}
