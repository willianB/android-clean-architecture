package service;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;


/**
 * Created by willian bustos on 10/02/17.
 */
public class ServiceLocal<T> {

    protected static Gson g;

    private T api;

    public T getApi() {
        if (api == null) {
            @SuppressWarnings("unchecked") final Class<T> persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];

            api = Http.sharedInstance().create(persistentClass);
        }

        return api;
    }


}
