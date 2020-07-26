package com.georgegtony.tunatheatre.mvp.Presenter

import com.georgegtony.tunatheatre.mvp.Contract.BaseContract
import com.georgegtony.tunatheatre.mvp.Contract.SignInContract
import com.google.gson.Gson
import com.kinderpass.network.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class SignInPresenter  : BaseContract<SignInContract.View>(),
    SignInContract.Presenter {
    override fun doLogin(loginType: String, device_type: String, device_id: String) {
        view?.showProgressBar()
        compoundDisposable.add(
            apiService.doLogin(loginType,device_type,device_id
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    run {
                        val response = result

                        val gson = Gson()
                        Timber.d("response: %s", gson.toJson(response))

                        try {
                            when (response.response) {
                                "success" -> {

                                    view?.loginResponse(response)

                                    view?.dismissProgressBar(null)
                                }
                                else -> {
                                    view?.dismissProgressBar(Throwable("No data available now"))
                                }
                            }
                        } catch (n: NullPointerException) {
                            view?.dismissProgressBar(Throwable("No data available now"))
                        }
                    }
                }, { error ->
                    run {
                        view?.dismissProgressBar(error)
                    }
                })
        )
    }

    private val apiService by lazy { RetrofitHelper.create() }
    private lateinit var compoundDisposable: CompositeDisposable
    override fun attach(view: SignInContract.View) {
        super.attach(view)
        compoundDisposable = CompositeDisposable()
    }


    override fun detach() {
        super.detach()
        compoundDisposable.dispose()
    }
}