package com.example.compose.domain.model.api_model

const val client_id = "mngdvi5yo61bexwzsixfyznzoyphya"
const val client_secret = "jm32k3nplhjpa5v7dmw69acsh9un1q"
const val grant_type = "client_credentials"

data class Token(
    val access_token: String,
    val expires_in:Int,
    val token_type:String
)
