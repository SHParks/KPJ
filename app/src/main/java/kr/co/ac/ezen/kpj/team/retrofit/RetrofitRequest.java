package kr.co.ac.ezen.kpj.team.retrofit;

import java.util.ArrayList;

import kr.co.ac.ezen.kpj.team.Beans.Board_Comment;
import kr.co.ac.ezen.kpj.team.Beans.Board_File;
import kr.co.ac.ezen.kpj.team.Beans.Board_Item;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018-02-22.
 */

public interface RetrofitRequest {

    @Multipart
    @POST("writed")
    Call<Void> insertData(@Part MultipartBody.Part photo, @Part("title") RequestBody title
            , @Part("name") RequestBody name, @Part("content") RequestBody content, @Part("pw") RequestBody pw);

    @GET("writed_cmt")
    Call<Void> insertCmt(@Query("id_board") String id_board, @Query("cmt_name") String cmt_name, @Query("cmt_pw") String cmt_pw, @Query("cmt_content") String cmt_content);

    @GET("json_list")
    Call<ArrayList<Board_Item>> getItemList();

    @GET("json_item")
    Call<Board_Item> getItem(@Query("id") String id);

    @GET("delete_android")
    Call<Integer> deleteItem(@Part("type") RequestBody type, @Part("id") RequestBody id, @Part("pw") RequestBody pw);

    @GET("delOk")
    Call<String> deleteItem2(@Query("type") String type, @Query("id_del") String id_del, @Query("pw_del") String pw_del);

    @GET("views_up")
    Call<Void> clickId(@Query("id") String id);

    @GET("getFile")
    Call<ArrayList<Board_File>> getFile(@Query("id") String id);

    @GET("getCmt")
    Call<ArrayList<Board_Comment>> getCmt(@Query("id") String id);

    @GET("editOk")
    Call<String> editItem(@Query("id") String id,@Query("title") String title, @Query("content") String content,@Query("pw") String pw);

    @GET("editOk")
    Call<Void> editItem2(@Query("id") String id,@Query("title") String title, @Query("content") String content,@Query("pw") String pw);

    @GET("pwCheck")
    Call<String> pwCheck(@Query("id") String id,@Query("pw") String pw);
}
