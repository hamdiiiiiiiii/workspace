package com.mongo.entitie;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document /* l'objet categorie sera un document JSON */
		  /* dans une bs MongoDB tt les données sont stocker dans des collection */
		  /* la collection est ensemble des documents */
          /* la document contient des objets sous format JSON (ligne classique d'enrigestrement table mais sous format Json) */
@Data     /*annotation Lombok qui représenter les getter et les setter */
@AllArgsConstructor /* constructeur avec tt les paramètres */
@NoArgsConstructor /* constructeur sans paramètres */
@ToString /* méthode toString */
public class Category {
 
	@Id  /* annotation spring data !! */
	private  String id;
	private String name;
	/* sans des annotation ==> les products sera enrigestrer avec la categorie */
						/* si non ; */
	/* pour creer une document pour les ategorie et une document pour les prodcts */
	@DBRef /* dans une document categorie, pn enregistrer que les ids des produit */
	private Collection<Product> products=new ArrayList<>();
	
	
}
