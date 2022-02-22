package dev.message.core

import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(path = ["/v1/proxy"])
class ProxyController {
    @PostMapping
    fun proxy(@RequestBody request: RequestJson): ResponseEntity<Any> {
        println(request.toDomain())
        return ResponseEntity.ok("ciaon")
    }
}

data class RequestJson(
    val index: String,
    val url: String,
    val method: String
) {
    fun toDomain() =
        Request(
            index = Index(index),
            url = URI(url),
            method = HttpMethod.valueOf(method)
        )
}

data class Request(
    val index: Index,
    val url: URI,
    val method: HttpMethod
)

@JvmInline
value class Index(
    val value: String
)