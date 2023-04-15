package com.example.compose.domain.usecase

import com.example.compose.data.DomainRepositoryImpl
import javax.inject.Inject

class LoadM3U8UseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl,
    private val id:String,
    private val mediaType:String
) : BaseUseCase<String>() {
    override suspend fun invoke(): String = domainRepository.getM3U8Link(id, mediaType)
}