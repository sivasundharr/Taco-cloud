package com.siva.tacocloud.data;

import com.siva.tacocloud.Ingredient;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,String>{

    
}
