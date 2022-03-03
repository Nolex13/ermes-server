package dev.message.core.data

import org.springframework.http.HttpStatus

data class ResponseJson(
    val index: String,
    val body: String?,
    val headers: Set<KeyValueMap>,
    val status: Status
) {
    data class Status(
        val description: String,
        val value: Int,
        val series: HttpStatus.Series,
        val reason: String
    )
}