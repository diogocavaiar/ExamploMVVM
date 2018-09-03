package br.com.diogocavaiar.examplomvvm.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.diogocavaiar.examplomvvm.domain.data.remote.response.Response

abstract class BaseViewModel<T> : ViewModel() {

     val response: MutableLiveData<Response<T>> = MutableLiveData()

     val loadingStatus: MutableLiveData<Boolean> = MutableLiveData()

     abstract fun loadData()

}