package com.georgegtony.tunatheatre.mvp.Contract

import com.georgegtony.tunatheatre.mvp.Presenter.BasePresenter
import com.georgegtony.tunatheatre.mvp.model.LoginResponseModel
import com.kinderpass.mvp.view.BaseView

class SignInContract {

    interface Presenter : BasePresenter<View> {
        fun doLogin(loginType: String, device_type: String, device_id: String)
    }

    interface View : BaseView {

        fun loginResponse(loginResponseModel: LoginResponseModel)


    }

}