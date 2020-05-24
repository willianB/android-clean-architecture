package repository;

import com.pragma.domain.BusinessException;
import com.pragma.domain.Product;

import org.jdeferred.Promise;

import java.util.List;

/**
 * Created by Willian Bustos on 9/04/2020.
 */
public class ProductRepository {

    private ProductPersistenceSource productPersistenceSource;

    public ProductRepository(ProductPersistenceSource productPersistenceSource) {
        this.productPersistenceSource = productPersistenceSource;
    }

    public Promise<List<Product>, BusinessException, List<Product>> getAllProducts() {
        return productPersistenceSource.getProducts();
    }

    public Promise newProduct() {
        return productPersistenceSource.newProduct();
    }

    public interface ProductPersistenceSource {
        public Promise getProducts();

        public Promise newProduct();
    }
}

