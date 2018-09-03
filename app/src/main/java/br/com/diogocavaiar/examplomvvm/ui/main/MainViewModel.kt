package br.com.diogocavaiar.examplomvvm.ui.main

import br.com.diogocavaiar.examplomvvm.domain.data.remote.response.Response
import br.com.diogocavaiar.examplomvvm.domain.data.remote.response.Status
import br.com.diogocavaiar.examplomvvm.domain.model.Item
import br.com.diogocavaiar.examplomvvm.domain.repository.JavaRepository
import br.com.diogocavaiar.examplomvvm.ui.base.BaseViewModel
import br.com.diogocavaiar.examplomvvm.util.schedulers.BaseScheduler
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val scheduler: BaseScheduler,
        private val javaRepository: JavaRepository
) : BaseViewModel<List<Item>>() {


    override fun loadData() {
        javaRepository.getJavaRepository()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnSubscribe { loadingStatus.setValue(true) }
                .doAfterTerminate { loadingStatus.setValue(false) }
                .subscribe({
                    result -> response.setValue(Response(Status.SUCCESS, result.items, null))
                }, {
                    throwable -> response.setValue(Response(Status.ERROR, null, throwable))
                })
    }
}