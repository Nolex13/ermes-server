package dev.message.core.data

import org.springframework.http.HttpMethod
import java.net.URI

data class Request(
    val index: Index,
    val url: URI,
    val method: HttpMethod,
    val params: Set<KeyValueMap>,
    val headers: Set<KeyValueMap>,
    val body: String?
)