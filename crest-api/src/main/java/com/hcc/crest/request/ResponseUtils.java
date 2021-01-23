package com.hcc.crest.request;


public class ResponseUtils<K> {

    public static <V> Response<V> success(V obj) {

//        Response<Object> objectResponse = new Response<>();
//        objectResponse.setSuccess(true)
//                .setCode("200");
//
//
//        Response<Object> build = Response.builder()
//                .success(true)
//                .code("200")
//                .build();

        return new Response<V>(true, "200", obj, "成功了");
    }

    public static <V> Response<V> success() {
        return new Response<V>(true, "200", null, "成功了");
    }

    public static Response<Void> fail() {
        return new Response<>(false, "500", null, "失败了");
    }

    public static <T> Response<T> fail(String msg) {
        return new Response<>(false, "500", null, msg);
    }


}
