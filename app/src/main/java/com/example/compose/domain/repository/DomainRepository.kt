package com.example.compose.domain.repository

import com.example.compose.domain.model.api_model.Stream

interface DomainRepository {
   suspend fun updateStreams(): MutableList<Stream>
}