package com.georgegtony.tunatheatre.mvp.Contract

import com.georgegtony.tunatheatre.mvp.Presenter.BasePresenter
import com.georgegtony.tunatheatre.mvp.model.HomePageList
import com.georgegtony.tunatheatre.mvp.model.MovieListResponseModel
import com.kinderpass.mvp.view.BaseView

class GetMovieListContract {

    interface Presenter : BasePresenter<View> {
        fun getMovieList(user_id: Int, cinema_id: String, device_id: String)
    }

    interface View : BaseView {

        fun showMovieList(model: MovieListResponseModel)


    }

}