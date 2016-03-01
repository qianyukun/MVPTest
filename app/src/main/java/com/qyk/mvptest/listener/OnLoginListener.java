package com.qyk.mvptest.listener;
/**
 * 回调接口
 */
import com.qyk.mvptest.bean.User;

public interface OnLoginListener
{
    void loginSuccess(User user);

    void loginFailed();
}