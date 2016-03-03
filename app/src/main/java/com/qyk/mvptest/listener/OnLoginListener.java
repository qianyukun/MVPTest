package com.qyk.mvptest.listener;

import com.gaosi.model.TeacherInfo;

/**
 * 回调接口
 */

public interface OnLoginListener
{
    void loginSuccess(TeacherInfo teacherInfo);

    void loginFailed(String message);
}