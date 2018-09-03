package br.com.diogocavaiar.examplomvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.diogocavaiar.examplomvvm.R
import br.com.diogocavaiar.examplomvvm.databinding.ActivityUserBinding
import br.com.diogocavaiar.examplomvvm.domain.data.remote.response.Status
import br.com.diogocavaiar.examplomvvm.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityUserBinding, MainViewModel>() {

    private var binding: ActivityUserBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeLoadingStatus()
        observeResponse()
    }

    override fun onStart() {
        super.onStart()
        getViewModel().loadData()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_user
    }

    override fun initDataBinding() {
        binding = getViewDataBinding()
    }

    override fun loadComponents() {
        binding!!.recyclerView.layoutManager = LinearLayoutManager(this)
        binding!!.swipeContainer.setOnRefreshListener(getViewModel()::loadData)
    }

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private fun observeResponse() {
        getViewModel().loadingStatus.observe(
                this,
                Observer {
                    isLoading -> binding!!.swipeContainer.isRefreshing = isLoading ?: false
                })
    }

    private fun observeLoadingStatus() {
        getViewModel().response.observe(
                this,
                Observer { response ->
                    if(response != null && response.status == Status.SUCCESS) {
                        binding!!.item = response.data
                    } else {
                        if (response != null && response.status == Status.ERROR) {
                            showMessage(response.error.toString())
                        }
                    }
                }
        )
    }
}
