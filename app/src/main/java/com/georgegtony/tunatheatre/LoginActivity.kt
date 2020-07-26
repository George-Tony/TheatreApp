package com.georgegtony.tunatheatre

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.georgegtony.tunatheatre.helpers.AppPreference
import com.georgegtony.tunatheatre.mvp.Contract.SignInContract
import com.georgegtony.tunatheatre.mvp.Presenter.SignInPresenter
import com.georgegtony.tunatheatre.mvp.model.LoginResponseModel
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

class LoginActivity : AppCompatActivity(), SignInContract.View {

    lateinit var signInPresenter: SignInPresenter

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        RxView.clicks(btn_guestUser).subscribe {
            signInPresenter = SignInPresenter()
            signInPresenter.attach(this)
            signInPresenter.doLogin("guest", "android", "4578467ddfaf")
        }
    }

    override fun loginResponse(loginResponseModel: LoginResponseModel) {
        applicationContext.let {
            when (loginResponseModel.response) {
                "success" -> {
                    Toast.makeText(
                        applicationContext,
                        loginResponseModel.message,
                        Toast.LENGTH_LONG
                    ).show()

                    AppPreference(this).user_id = loginResponseModel.user_id
                    AppPreference(this).device_id = loginResponseModel.user.username

                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }
                "failed" -> {
                    Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_LONG).show()
                }
                else -> Timber.e("something went wrong")
            }
        }
    }

    override fun showProgressBar() {
    }

    override fun dismissProgressBar(error: Throwable?) {
        Timber.e("something went wrong: $error")
    }

    override fun onDestroy() {
        super.onDestroy()
        signInPresenter.detach()
    }

}