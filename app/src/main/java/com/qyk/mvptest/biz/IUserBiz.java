package com.qyk.mvptest.biz;

import com.qyk.mvptest.listener.OnLoginListener;

/**
 *业务层--接口
 */
public interface IUserBiz
{
    public void login(String username, String password, OnLoginListener loginListener);
}