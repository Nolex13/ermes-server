package dev.message.core.usecase

import com.fasterxml.jackson.databind.JsonNode
import dev.message.core.data.Request
import dev.message.core.data.Response
import org.springframework.http.HttpEntity
import org.springframework.web.client.RestTemplate

class ProxyUseCase(
    private val restTemplate: RestTemplate
) {
    fun executeUsing(request: Request): Response {
        val requestEntity: HttpEntity<String> = HttpEntity<String>("")
        val exchange = restTemplate.exchange(request.url, request.method, requestEntity, JsonNode::class.java)
        return Response(
            index = request.index,
            body = exchange.body,
            status = exchange.statusCode,
            headers = exchange.headers,
        )
    }
}