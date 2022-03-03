package dev.message.core.controllers

import dev.message.core.data.RequestJson
import dev.message.core.data.ResponseJson
import dev.message.core.usecase.ProxyUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = ["/v1/proxy"])
class ProxyController(
    private val proxyUseCase: ProxyUseCase
) {
    @PostMapping
    fun proxy(@RequestBody request: RequestJson): ResponseEntity<ResponseJson> =
        ResponseEntity.ok(
            proxyUseCase.executeUsing(request.toDomain()).toJson()
        )
}