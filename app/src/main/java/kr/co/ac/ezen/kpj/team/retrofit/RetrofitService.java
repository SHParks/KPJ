package kr.co.ac.ezen.kpj.team.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018-01-29.
 */

public class RetrofitService {
    public static RetrofitService curr = null;
    private RetrofitRequest retrofitRequest;

    public static RetrofitService getInstance(){
        if (curr == null){
            curr = new RetrofitService();
        }
        return  curr;
    }

    public RetrofitService() {
        retrofitRequest = init();
    }

    public  RetrofitRequest init(){
        //Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.16.141.202:8090/shp/") .addConverterFactory(GsonConverterFactory.create()).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://13.125.173.223:8080/shp/") .addConverterFactory(GsonConverterFactory.create()).build();


        return retrofit.create(RetrofitRequest.class);
    }

    public RetrofitRequest getRetrofitRequest() {
        return retrofitRequest;
    }
}
