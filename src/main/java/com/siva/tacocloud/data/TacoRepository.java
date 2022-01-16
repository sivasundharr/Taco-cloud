package com.siva.tacocloud.data;

import com.siva.tacocloud.Taco;

import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco,Long>{
    
}
