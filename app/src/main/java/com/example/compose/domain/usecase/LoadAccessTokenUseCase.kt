package com.example.compose.domain.usecase

import com.example.compose.data.DomainRepositoryImpl
import javax.inject.Inject

class LoadAccessTokenUseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl,

    ) : BaseUseCase<String>() {
    override suspend fun invoke(): String = domainRepository.getAccessToken()
}