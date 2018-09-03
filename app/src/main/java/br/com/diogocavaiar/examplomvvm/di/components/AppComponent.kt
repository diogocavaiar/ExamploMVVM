package br.com.diogocavaiar.examplomvvm.di.components

import br.com.diogocavaiar.examplomvvm.App
import br.com.diogocavaiar.examplomvvm.di.modules.ActivityBuildersModule
import br.com.diogocavaiar.examplomvvm.di.modules.AppModule
import br.com.diogocavaiar.examplomvvm.di.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuildersModule::class,
    AppModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}