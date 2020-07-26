package com.georgegtony.tunatheatre.mvp.Contract

import com.georgegtony.tunatheatre.mvp.Presenter.BasePresenter
import com.kinderpass.mvp.view.BaseView

open class BaseContract<V : BaseView> : BasePresenter<V> {

    /**
     * Attached view
     */
    var view: V? = null


    override val isAttached = view != null


    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        view = null
    }
}