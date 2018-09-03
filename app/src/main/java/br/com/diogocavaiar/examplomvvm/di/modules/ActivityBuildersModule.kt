package br.com.diogocavaiar.examplomvvm.di.modules

import br.com.diogocavaiar.examplomvvm.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface ActivityBuildersModule {

    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity

}