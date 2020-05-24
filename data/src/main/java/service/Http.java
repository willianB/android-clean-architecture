package service;


import org.jdeferred.Deferred;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Http {
    private static Retrofit instance;
    private static OkHttpClient client;
//    public static String URL_SERVER = "http://node43490-postgres.jl.serv.net.mx/";
//    public static String URL_SERVER = "http://ec2-54-212-148-11.us-west-2.compute.amazonaws.com:8080/tmerca/";
//    public static String URL_SERVER = "http://52.13.87.15:8080/tmerca/";
    public static String URL_SERVER = "http://192.168.1.74:8080/tmerca_backend_war/";
//    public static String URL_SERVER = "http://50.112.225.141:8080/tmerca/";
        //    public static String URL_SERVER = "http://192.168.1.200:8080/sparkjava_hello_world_war/";

    public static <T> boolean validateAcceptableStatusCode(Response<T> response) {
        return response.code() >= 200 && response.code() < 300;
    }

    private static OkHttpClient getClient() {
        if (client == null) {
            final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addNetworkInterceptor(chain -> {
                final Request original = chain.request();
                final Request request = original.newBuilder()
                        .header("Accept", "application/json;charset=utf-8")
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body()).build();
                return chain.proceed(request);
            }).connectTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .build();

            client = httpClient.build();
        }

        return client;
    }

    /**
     * Genera una instancia compartida para crear clientes para servicios
     *
     * @return {@link Retrofit }
     */
    public static Retrofit sharedInstance() {
        if (instance != null) {
            final String urlInstance = String.valueOf(instance.baseUrl());
            if (!urlInstance.equalsIgnoreCase(URL_SERVER)) {
                instance = null;
            }
        }

        if (instance == null) {
            instance = new Retrofit.Builder().baseUrl(URL_SERVER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient()).build();
        }

        return instance;
    }


    /**
     * Crea una promesa apartir de una llamada usando el api de retrofit
     *
     * @param call
     * @return
     */
    public static <T> Promise<T, Throwable, T> request(Call<T> call) {
        final Deferred<T, Throwable, T> deferred = new DeferredObject<>();


        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (Http.validateAcceptableStatusCode(response)) {
                    deferred.resolve(response.body());
                } else {
                    deferred.reject(null);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
//                TrackerUtil.newExceptionEvent(t);

                deferred.reject(null);
            }
        });

        return deferred.promise();
    }

}