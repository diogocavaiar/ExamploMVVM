package br.com.diogocavaiar.examplomvvm.di.modules

import br.com.diogocavaiar.examplomvvm.data.remote.Api
import br.com.diogocavaiar.examplomvvm.domain.repository.JavaRepository
import br.com.diogocavaiar.examplomvvm.util.schedulers.BaseScheduler
import br.com.diogocavaiar.examplomvvm.util.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideJavaRepository(api: Api): JavaRepository {
        return JavaRepository(api)
    }

    @Provides
    @Singleton
    fun provideScheduler(): BaseScheduler {
        return SchedulerProvider()
    }

}