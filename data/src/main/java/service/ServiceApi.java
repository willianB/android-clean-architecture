package service;//package com.tmerca.shoppingcart.core.service;
//
//import java.lang.reflect.ParameterizedType;
//
//
//public abstract class ServiceApi<T> {
//
//    protected T api;
//
//    public T getApi() {
//        if (api == null) {
//            @SuppressWarnings("unchecked") final Class<T> persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
//                    .getActualTypeArguments()[0];
//
//            api = Http.sharedInstance().create(persistentClass);
//
//        }
//        return api;
//    }
//
//}
