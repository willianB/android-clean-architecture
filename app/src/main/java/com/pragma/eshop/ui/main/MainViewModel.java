package com.pragma.eshop.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pragma.domain.Product;

public class MainViewModel extends ViewModel {

    protected MutableLiveData<Product> productLiveData = new MutableLiveData<>();


    public void loadProduct(){

        Product product = new Product();
        product.setName("Coka-Cola");
        product.setDescription("Bebida refrescante");
        product.setPrice(2300);
        productLiveData.setValue(product);
    }
}
