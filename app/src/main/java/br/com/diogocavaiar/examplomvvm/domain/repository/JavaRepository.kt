package br.com.diogocavaiar.examplomvvm.domain.repository

import br.com.diogocavaiar.examplomvvm.data.remote.Api
import br.com.diogocavaiar.examplomvvm.data.remote.response.GitHubResponse
import io.reactivex.Observable
import javax.inject.Inject


class JavaRepository @Inject constructor(private val api: Api) {

    fun getJavaRepository(): Observable<GitHubResponse> {
        return api.fetchJavaRepository(1)
    }
}