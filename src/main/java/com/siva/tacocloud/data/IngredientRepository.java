package com.siva.tacocloud.data;

import com.siva.tacocloud.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
    
}
