package dataSource;

import com.pragma.domain.BusinessException;
import com.pragma.domain.Product;

import org.jdeferred.Deferred;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

import java.util.ArrayList;
import java.util.List;

import repository.ProductRepository;

/**
 * Created by Willian Bustos on 9/04/2020.
 */
public class ProductLocalSource  implements ProductRepository.ProductPersistenceSource {

    public List<Product> getAllLocalProducts() {
        List<Product> products = new ArrayList<>();
        Product p = null;

        for (int i = 0; i < 10; i++) {
            p = new Product();
            p.setName("prodict #" + i);
            products.add(p);
        }

        return products;
    }

    @Override
    public Promise getProducts() {
        Deferred<List<Product>, BusinessException, List<Product>> deferred = new DeferredObject<>();
        return deferred.resolve(getAllLocalProducts());
    }

    @Override
    public Promise newProduct() {
        return null;
    }
}
