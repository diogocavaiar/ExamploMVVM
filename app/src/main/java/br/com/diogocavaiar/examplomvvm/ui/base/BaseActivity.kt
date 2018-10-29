package br.com.diogocavaiar.examplomvvm.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import br.com.diogocavaiar.examplomvvm.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    @JvmField var viewModelFactory: ViewModelProvider.Factory? = null

    private lateinit var mViewDataBinding: T
    private lateinit var mViewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        performDataBinding()
        initDataBinding()
        loadComponents()
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    fun showMessage(message: String) {
        Snackbar.make(mViewDataBinding.root, message, Snackbar.LENGTH_LONG).show()
    }

    @LayoutRes
    abstract fun getLayoutId() : Int
    abstract fun initDataBinding()
    abstract fun loadComponents()
    abstract fun getViewModel(): V
}