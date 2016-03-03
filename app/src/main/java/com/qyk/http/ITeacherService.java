package com.qyk.http;

import com.gaosi.model.TeacherInfo;
import com.qyk.common.ResultData;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ITeacherService {
    @FormUrlEncoded
    @POST("teacher/login")
    //异步
    Call<ResultData<TeacherInfo>> login(@Field("telPhone") String telPhone, @Field("password") String password);

}
