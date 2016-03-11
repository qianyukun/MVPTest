package com.qyk.mvptest.view;

import android.content.Context;

import com.gaosi.model.TeacherInfo;

/**
 * 对于View的接口，去观察功能上的操作，然后考虑：
 该操作需要什么？（getUserName, getPassword）
 该操作的结果，对应的反馈？(toMainActivity, showFailedError)
 该操作过程中对应的友好的交互？(showLoading, hideLoading)
 */
public interface IUserLoginView
{
    //获得用户名
    String getUserName();
    //获得密码
    String getPassword();
    //清除用户名
    void clearUserName();
    //清除密码
    void clearPassword();
    //显示加载中
    void showLoading();
    //隐藏加载中
    void hideLoading();
    //登录成功，跳转主界面
    void toMainActivity(TeacherInfo user);
    //跳转忘记密码页
    void toForgetPasswordActivity();
    //显示错误信息
    void showFailedError(String message);
}