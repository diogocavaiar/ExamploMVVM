package br.com.diogocavaiar.examplomvvm.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    @JvmField var viewModelFactory: ViewModelProvider.Factory? = null

    private var mViewDataBinding: T? = null
    private var mViewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        performDataBinding()
        initDataBinding()
        loadComponents()
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView<T>(this, getLayoutId())
    }

    fun getViewDataBinding(): T? {
        if(mViewDataBinding == null) throw RuntimeException("Ocorreu um erro!Data Binding NULL")
        return mViewDataBinding
    }

    fun showMessage(message: String) {
        Snackbar.make(mViewDataBinding!!.root, message, Snackbar.LENGTH_LONG).show()
    }

    @LayoutRes
    abstract fun getLayoutId() : Int
    abstract fun initDataBinding()
    abstract fun loadComponents()
    abstract fun getViewModel(): V
}