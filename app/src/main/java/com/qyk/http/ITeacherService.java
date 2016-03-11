package com.qyk.http;

import com.gaosi.model.LoginInfo;
import com.gaosi.model.TeacherInfo;
import com.qyk.common.ResultData;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Path;

public interface ITeacherService {
    @FormUrlEncoded
    @POST("teacher/login")
    //异步
    Call<ResultData<TeacherInfo>> login(@Field("telPhone") String telPhone, @Field("password") String password);

    @FormUrlEncoded
    @POST("requestVerifyCode")
    Call<ResultData<String>> requestVerifyCode(@Field("telPhone") String var1);

    @FormUrlEncoded
    @POST("verifyVerifyCode")
    Call<ResultData<Void>> verifyVerifyCode(@Field("telPhone") String var1, @Field("checkCode") String var2);


    @FormUrlEncoded
    @POST("resetPassword")
    Call<ResultData<TeacherInfo>> resetPassword(@Field("telPhone") String var1, @Field("newPassword") String var2);

    @FormUrlEncoded
    @POST("login/{telPhone}/{password}")
    Call<ResultData<TeacherInfo>> login(@Path("telPhone") String var1, @Path("password") String var2, @Body LoginInfo var3);

    @POST("check/{teacherId}/{registrationId}")
    Call<ResultData<Integer>> checkLoginState(@Path("teacherId") String var1, @Path("registrationId") String var2);
}
