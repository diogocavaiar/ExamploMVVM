package br.com.diogocavaiar.examplomvvm.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.diogocavaiar.examplomvvm.di.keys.ViewModelKey
import br.com.diogocavaiar.examplomvvm.ui.common.ViewModelFactory
import br.com.diogocavaiar.examplomvvm.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindListMainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}