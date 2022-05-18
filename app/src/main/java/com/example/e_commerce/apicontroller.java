package com.example.e_commerce;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apicontroller {
    static final String url="http://192.168.189.169/shopii/";
    private  static apicontroller clientobject;
    private static Retrofit retrofit;

    apicontroller(){
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized apicontroller getInstance(){   //ab ye check karega ki object phle sai insiltized hai
        // agar hai too usi object ko return kar dega agar nhi hai too phir sai usse bannega
        if (clientobject==null)
            clientobject=new apicontroller();
        return clientobject;
    }

    apiset getapi(){

        return retrofit.create(apiset.class);
    }


}
