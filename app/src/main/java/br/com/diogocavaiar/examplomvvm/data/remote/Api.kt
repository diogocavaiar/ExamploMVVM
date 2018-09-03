package br.com.diogocavaiar.examplomvvm.data.remote

import br.com.diogocavaiar.examplomvvm.data.remote.response.GitHubResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun fetchJavaRepository(@Query("page") page: Int) : Observable<GitHubResponse>

}