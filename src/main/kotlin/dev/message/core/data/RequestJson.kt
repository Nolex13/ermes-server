package dev.message.core.data

import org.springframework.http.HttpMethod
import java.net.URI

data class RequestJson(
    val index: String,
    val url: String,
    val method: String,
    val params: List<KeyValueMap>,
    val headers: List<KeyValueMap>,
    val body: String?
) {
    fun toDomain() =
        Request(
            index = Index(index),
            url = URI(url),
            method = HttpMethod.valueOf(method),
            params = params.toSet(),
            headers = headers.toSet(),
            body = body
        )
}