package com.qyk.mvptest.presenter;

import android.os.Handler;

import com.gaosi.model.TeacherInfo;
import com.qyk.common.HttpString;
import com.qyk.common.ResultData;
import com.qyk.http.ITeacherService;
import com.qyk.mvptest.view.IUserLoginView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 主导器层
 * <p/>
 * Presenter是用作Model和View之间交互的桥梁，那么应该有什么方法呢？
 * 其实也是主要看该功能有什么操作，比如本例，两个操作:login和clear。
 */
public class UserLoginPresenter {
    //事务
    private ITeacherService teacherService;
    //
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(HttpString.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.userLoginView = userLoginView;
        this.teacherService = retrofit.create(ITeacherService.class);
    }

    public void login() {
        userLoginView.showLoading();
        Call<ResultData<TeacherInfo>> response = teacherService.login(userLoginView.getUserName(), userLoginView.getPassword());
        response.enqueue(new Callback<ResultData<TeacherInfo>>() {
            @Override
            public void onResponse(Response<ResultData<TeacherInfo>> response, Retrofit retrofit) {
                final ResultData<TeacherInfo> resultData = response.body();
                if (resultData != null){
                    Integer status = resultData.getStatus();
                    if (status == 1) {
                        //需要在UI线程执行
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                userLoginView.toMainActivity(resultData.getData());
                                userLoginView.hideLoading();
                            }
                        });
                    }else{

                        final String message = resultData.getMessage();
                        //需要在UI线程执行
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                userLoginView.showFailedError(message);
                                userLoginView.hideLoading();
                            }
                        });
                    }
                }else{
                    final String message = "系统异常";
                    //需要在UI线程执行
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            userLoginView.showFailedError(message);
                            userLoginView.hideLoading();
                        }
                    });
                }
            }
            @Override
            public void onFailure(Throwable t) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError("请检查网络");
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }


}