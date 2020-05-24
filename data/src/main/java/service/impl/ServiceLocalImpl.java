package service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.pragma.domain.BusinessException;
import com.pragma.domain.Product;

import org.jdeferred.Deferred;
import org.jdeferred.DoneCallback;
import org.jdeferred.FailCallback;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import service.EntityService;
import service.Http;
import service.ServiceLocal;


/**
 * Created by willian bustos on 29/01/19.
 */
public class ServiceLocalImpl extends ServiceLocal<EntityService> {

    public ServiceLocalImpl() {
        g = new Gson();
    }

    public <T extends Product> Promise getAllData() {
        Deferred deferred = new DeferredObject();
//        Http.request(getApi().getEntityAllData()).done((DoneCallback<JsonObject>) responseBody -> {
//            deferred.resolve(g.fromJson(responseBody, DataDTO.class));
//
//        }).fail((FailCallback<BusinessException>) error -> {
//            deferred.reject(error);
//        });

        return deferred;
    }


    /**
     * Devuelve un json a partir de un ResponseBody
     *
     * @param r ResponseBody
     * @return String json
     */
    private String getJsonFromResponseBody(final ResponseBody r) {
        final BufferedReader reader = new BufferedReader(r.charStream());

        try {
            return reader.readLine();
        } catch (final IOException e) {
            return "";
        }
    }

}