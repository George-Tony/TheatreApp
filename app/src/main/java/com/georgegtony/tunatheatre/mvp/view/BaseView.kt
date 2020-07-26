package com.kinderpass.mvp.view

interface BaseView {

    fun showProgressBar()

    fun dismissProgressBar(error: Throwable? = null)
}