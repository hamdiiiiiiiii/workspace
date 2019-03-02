package com.mongo.appl;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongo.dao.CategoryRepository;
import com.mongo.dao.ProductRepository;
import com.mongo.entitie.Category;
import com.mongo.entitie.Product;

@SpringBootApplication
@EntityScan("com.mongo.entitie")
@EnableMongoRepositories("com.mongo.dao")
public class CategorieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategorieServiceApplication.class, args);
	}

	@Bean /*annotation indique que cette methode sera excuter lors du démarrage du projet */
	CommandLineRunner start(CategoryRepository categoryRepository , ProductRepository productRepository){
		return args ->{
			categoryRepository.deleteAll(); /* supprimer tout les données */
			 Stream.of("C1 Ordinateurs" ,"C2 Imprimantes").forEach(c->{
				 categoryRepository.save(new Category(c.split(" ")[0] ,c.split(" ")[1] ,new ArrayList<>())); 
			 });
			 
			 categoryRepository.findAll().forEach(System.out::println);
			 productRepository.deleteAll();
			 
			 Category c1 = categoryRepository.findById("C1").get();
			 
			 Stream.of("P1" , "P2" , "P3" ,"P4").forEach(c->{
				 productRepository.save(new Product(null, c, Math.random()*1000,c1)); 
			 });
				 
				 
			 Category c2 = categoryRepository.findById("C2").get();
			 
			 Stream.of("P5" , "P6").forEach(c->{
				 productRepository.save(new Product(null, c, Math.random()*1000,c2)); 
			 });
			 
			 productRepository.findAll().forEach(p->{
				 System.out.println(p.toString());
			 });
		};
	}

}
