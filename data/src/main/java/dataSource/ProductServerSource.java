package dataSource;


import com.pragma.domain.Product;

import org.jdeferred.Promise;

import java.util.ArrayList;
import java.util.List;

import repository.ProductRepository;
import service.modelservice.DataService;

/**
 * Created by Willian Bustos on 9   /04/2020.
 */
public class ProductServerSource implements ProductRepository.ProductPersistenceSource {

    private DataService dataService;
    private List<Product> products;

    public ProductServerSource(){
        products = new ArrayList<>();
        dataService = new DataService();
    }

    @Override
    public Promise getProducts() {
        return dataService.getAllData();
    }

    @Override
    public Promise newProduct() {
        return null;
    }
}
