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

    private lateinit var binding: ActivityUserBinding

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
        binding.apply {
            recyclerView?.layoutManager = LinearLayoutManager(baseContext)
            swipeContainer.setOnRefreshListener(getViewModel()::loadData)
        }
    }

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private fun observeResponse() {
        getViewModel().loadingStatus.observe(
                this,
                Observer { isLoading ->
                    binding.swipeContainer.isRefreshing = isLoading ?: false
                })
    }

    private fun observeLoadingStatus() {
        getViewModel().response.observe(
                this,
                Observer { response ->
                    response.let {
                        if (it?.status == Status.SUCCESS)
                            binding.item = it.data
                        else if (it?.status == Status.ERROR)
                            showMessage(it.error.toString())
                    }
                }
        )
    }
}
