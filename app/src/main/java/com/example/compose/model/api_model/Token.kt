package com.example.compose.model.api_model

const val client_id = "mngdvi5yo61bexwzsixfyznzoyphya"
const val client_secret = "jm32k3nplhjpa5v7dmw69acsh9un1q"
const val grant_type = "client_credentials"
const val news_api = "9c95718ffc464bca8afb51977b2b1d0a"

data class Token(
    val access_token: String,
    val expires_in:Int,
    val token_type:String
)
