package com.georgegtony.tunatheatre

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.georgegtony.tunatheatre.helpers.AppPreference
import com.georgegtony.tunatheatre.mvp.Contract.GetMovieListContract
import com.georgegtony.tunatheatre.mvp.Contract.HomePageBannerContract
import com.georgegtony.tunatheatre.mvp.Presenter.GetMovieListPresenter
import com.georgegtony.tunatheatre.mvp.Presenter.HomePageBannerPresenter
import com.georgegtony.tunatheatre.mvp.model.HomePageList
import com.georgegtony.tunatheatre.mvp.model.MovieListResponseModel
import com.georgegtony.tunatheatre.mvp.model.Sliders
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_home.*
import timber.log.Timber

class HomeActivity : AppCompatActivity() ,HomePageBannerContract.View,GetMovieListContract.View{

    lateinit var homePageBannerPresenter: HomePageBannerPresenter
    lateinit var movieListPresenter: GetMovieListPresenter

    val cinemaList = listOf("canton","cinholly","hartland","macomb","Novi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        checkUserLogin()


        // get home page banner details
        homePageBannerPresenter = HomePageBannerPresenter()
        homePageBannerPresenter.attach(this)
        homePageBannerPresenter.getHomePageList(user_id = AppPreference(this).user_id?:0,
        cinema_id = "Novi",device_id = AppPreference(this).device_id?:"")

        //get movie list
        movieListPresenter = GetMovieListPresenter()
        movieListPresenter.attach(this)
        movieListPresenter.getMovieList(user_id = AppPreference(this).user_id?:0,
            cinema_id = "Novi",device_id = AppPreference(this).device_id?:"")


       // show cinema list
        val adapter = CinemaAdapter(context = applicationContext,mCinemaList = cinemaList)
        val mLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_cinema.layoutManager = mLayoutManager
        rv_cinema.adapter = adapter

    }

    override fun showPageList(homePageList: HomePageList) {
        applicationContext.let {

            //setup image slider
            setUpImageSlider(homePageList.sliders)


        }
    }

    override fun showMovieList(model: MovieListResponseModel) {
        applicationContext.let {

            //setUp Movie List

            val adapter = MovieAdapter(context = applicationContext,mMovieList = model.movie_list)
            val mLayoutManager = GridLayoutManager(applicationContext,2)
            rv_movieList.layoutManager = mLayoutManager
            rv_movieList.adapter = adapter

        }
    }

    override fun showProgressBar() {
    }

    override fun dismissProgressBar(error: Throwable?) {
        Timber.e("something went wrong: $error")

    }

    private fun checkUserLogin(){
        if(AppPreference(this).user_id == null || AppPreference(this).user_id ==0){
            val intent = Intent(this@HomeActivity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    private fun setUpImageSlider(sliders: List<Sliders>) {


        val adapter = SliderAdapter(context = applicationContext,mSliderItems = sliders)
        imageSlider.setSliderAdapter(adapter)

        imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM) //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        imageSlider.indicatorSelectedColor = Color.WHITE
        imageSlider.indicatorUnselectedColor = Color.GRAY
        imageSlider.scrollTimeInSec = 4 //set scroll delay in seconds :
        imageSlider.startAutoCycle()

    }


}