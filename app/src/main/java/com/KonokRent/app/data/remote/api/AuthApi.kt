package com.airbnbclone.app.data.remote.api

import com.airbnbclone.app.data.remote.dto.AuthResponseDto
import com.airbnbclone.app.data.remote.dto.LoginRequestDto
import com.airbnbclone.app.data.remote.dto.RegisterRequestDto
import com.airbnbclone.app.data.remote.dto.VerifyCodeRequestDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthApi(private val client: HttpClient) {
    suspend fun login(request: LoginRequestDto): AuthResponseDto {
        return client.post("/auth/login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
    
    suspend fun register(request: RegisterRequestDto): AuthResponseDto {
        return client.post("/auth/register") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
    
    suspend fun sendVerificationCode(phone: String) {
        client.post("/auth/send-verification-code") {
            contentType(ContentType.Application.Json)
            setBody(mapOf("phone" to phone))
        }
    }
    
    suspend fun verifyCode(request: VerifyCodeRequestDto): AuthResponseDto {
        return client.post("/auth/verify-code") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}

