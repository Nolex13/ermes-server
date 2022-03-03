package dev.message.core.data

import com.fasterxml.jackson.databind.JsonNode
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus

data class Response(
    val index: Index,
    val body: JsonNode?,
    val headers: HttpHeaders,
    val status: HttpStatus
) {
    fun toJson() =
        ResponseJson(
            index = index.value,
            body = body?.toString(),
            headers = headers.map { KeyValueMap(it.key, it.value.first()) }.toSet(),
            status = status.toJson()
        )

    private fun HttpStatus.toJson() =
        ResponseJson.Status(
            description = this.name,
            value = this.value(),
            series = this.series(),
            reason = this.reasonPhrase
        )
}