package service.modelservice;



import com.pragma.domain.BusinessException;
import com.pragma.domain.Product;

import org.jdeferred.Promise;

import java.util.List;

import service.Http;
import service.ServiceLocal;
import service.impl.ServiceLocalImpl;

public class DataService extends ServiceLocal<DataEntityService> {

    private ServiceLocalImpl service;

    public DataService() {
        service = new ServiceLocalImpl();
    }


    public Promise getAllData() {
        return service.getAllData();
    }


    public Promise getAllCategories() {
        String url = "categories";
        return service.getAllData();
    }

}
