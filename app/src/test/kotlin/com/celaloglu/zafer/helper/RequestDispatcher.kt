package com.celaloglu.zafer.helper

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

/**
 * Handles Requests from mock web server
 */
internal class RequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson("json/vehicles.json"))
            }
            else -> throw IllegalArgumentException("Unknown Request Path ${request.path.toString()}")
        }
    }

}
