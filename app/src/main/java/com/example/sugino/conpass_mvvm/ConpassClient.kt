package com.example.sugino.conpass_mvvm

import android.database.Observable
import retrofit2.http.GET
import java.util.*

interface ConpassClient {
    @GET("api/v1/event")
    fun event(): io.reactivex.Observable<ConpassEvent>
}