package com.example.soccerleauge

import com.example.soccerleauge.util.Resource
import retrofit2.Response
import java.lang.Exception

open class BaseRepository {

    protected suspend fun <T> getResult(call : suspend () -> Response<T>) : Resource<T> {

        try {
            val response = call()
            if (response.isSuccessful){
                val body = response.body()
                body?.let {
                    return Resource.succes(body)
                }
            }
            return error(response.message(),response.code())
        }catch (e: Exception){
            return error(e.message ?: e.toString(),e.hashCode())
        }


    }
    private fun <T> error(message: String, errorCode: Int): Resource<T> {
        return Resource.error("Network call has failed for a following reason: $message")
    }

}