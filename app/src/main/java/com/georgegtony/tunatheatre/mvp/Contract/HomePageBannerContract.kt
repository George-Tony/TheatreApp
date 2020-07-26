package com.georgegtony.tunatheatre.mvp.Contract

import com.georgegtony.tunatheatre.mvp.Presenter.BasePresenter
import com.georgegtony.tunatheatre.mvp.model.HomePageList
import com.georgegtony.tunatheatre.mvp.model.LoginResponseModel
import com.kinderpass.mvp.view.BaseView

class HomePageBannerContract {

    interface Presenter : BasePresenter<View> {
        fun getHomePageList(user_id: Int, cinema_id: String, device_id: String)
    }

    interface View : BaseView {

        fun showPageList(homePageList: HomePageList)


    }

}