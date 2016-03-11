package com.qyk.mvptest.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.gaosi.model.TeacherInfo;
import com.qyk.mvptest.R;
import com.qyk.mvptest.base.BaseActivity;
import com.qyk.mvptest.presenter.UserLoginPresenter;
import com.qyk.mvptest.view.IUserLoginView;

public class MainActivity extends BaseActivity implements IUserLoginView{

    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private RippleView ripple_login,ripple_clear,ripple_forget;
    private ProgressBar mPbLoading;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews()
    {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);

        mBtnClear = (Button) findViewById(R.id.id_btn_clear);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);

        ripple_login = (RippleView) findViewById(R.id.ripple_login);
        ripple_clear = (RippleView) findViewById(R.id.ripple_clear);
        ripple_forget = (RippleView) findViewById(R.id.ripple_forget);

        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });

        ripple_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.forgetPassWord();
            }
        });
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(TeacherInfo user) {
        Toast.makeText(this, user.getTeacherName() +
                "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toForgetPasswordActivity() {

    }

    @Override
    public void showFailedError(String message) {
        Toast.makeText(this,
                message, Toast.LENGTH_SHORT).show();
    }
}
