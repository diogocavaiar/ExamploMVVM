package br.com.diogocavaiar.examplomvvm.domain.data.remote.response

data class Response<out T> (
        val status: Int,
        val data: T?,
        val error: Throwable?
)