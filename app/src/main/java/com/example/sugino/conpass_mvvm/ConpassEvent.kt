package com.example.sugino.conpass_mvvm

import android.provider.CalendarContract
import com.google.gson.annotations.SerializedName

data class ConpassEvent (
        @SerializedName("results_returned")
        val resultsReturned: Long,
        @SerializedName("results_available")
        val resultsAvailable: Long,
        @SerializedName("results_start")
        val resultsStart: Long,
        val events: List<Event>

) {
    data class Event(
            @SerializedName("event_id")
            val eventId: Long,
            val title: String
    ) {
        data class Series(
                val id: Long,
                val title: String,
                val url: String
        )
    }
}