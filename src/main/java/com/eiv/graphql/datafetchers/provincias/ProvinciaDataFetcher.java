package com.eiv.graphql.datafetchers.provincias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eiv.entities.ProvinciaEntity;
import com.eiv.repositories.ProvinciaRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ProvinciaDataFetcher implements DataFetcher<ProvinciaEntity>{

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public ProvinciaEntity get(DataFetchingEnvironment environment) throws Exception {
       
        Integer id = environment.getArgument("id");
        
        return provinciaRepository.findById(id).orElse(null);
    }
}
