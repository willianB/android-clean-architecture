package com.pragma.usecase;


import com.pragma.domain.BusinessException;
import com.pragma.domain.Product;

import org.jdeferred.Promise;

import java.util.List;

import service.modelservice.DataService;

/**
 * Created by Willian Bustos on 9/04/2020.
 */
public class RequestProducts {

    private DataService dataService;

    public RequestProducts() {
        dataService = new DataService();
    }

    public Promise<List<Product>, BusinessException, List<Product>> getAllProducts() {
        return dataService.getAllCategories();
    }
}
