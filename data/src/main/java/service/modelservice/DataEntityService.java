package service.modelservice;



import com.pragma.domain.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DataEntityService {

    @GET("users/{user}/repos")
    Call<List<Product>> getAllProducts(@Path("user") String user);
}
