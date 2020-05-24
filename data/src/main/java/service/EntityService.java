package service;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

/**
 * Created by willian bustos on 16/02/17.
 */
public  interface EntityService<T> {


    @GET
    Call<ResponseBody> getEntityAllData(@Url String url);//esto se usa cuando el path de la url no tiene la extencion .json

    @GET
    Call<ResponseBody> getEntitySingleData(@Url String url);


    @Headers("Content-Type: application/json")
    @GET("tmercaproductos/datos/datos_1549343034522.json")
    Call<JsonObject> getEntityAllData(); //esto se uso de esta manera porque en la url el json tiene la extencion .json
}