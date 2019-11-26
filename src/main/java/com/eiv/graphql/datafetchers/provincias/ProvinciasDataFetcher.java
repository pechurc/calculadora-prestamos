package com.eiv.graphql.datafetchers.provincias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eiv.entities.ProvinciaEntity;
import com.eiv.repositories.ProvinciaRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ProvinciasDataFetcher implements DataFetcher<List<ProvinciaEntity>> {

    @Autowired
    private ProvinciaRepository provinciaRepository;
    
    @Override
    public List<ProvinciaEntity> get(DataFetchingEnvironment environment) throws Exception {
        return provinciaRepository.findAll();
    }

}
