package com.georgegtony.tunatheatre.mvp.Presenter

import com.kinderpass.mvp.view.BaseView


interface BasePresenter<V : BaseView>  {


    /**
     * @return true if view is attached to presenterInitiate
     */
    val isAttached: Boolean

    /**
     * Called when view attached to presenterInitiate
     *
     * @param view
     */
    fun attach(view: V)

    /**
     * Called when view is detached from presenterInitiate
     */
    fun detach()
}