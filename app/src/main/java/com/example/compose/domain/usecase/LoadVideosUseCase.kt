package com.example.compose.domain.usecase

import com.example.compose.data.DomainRepositoryImpl
import com.example.compose.domain.model.api_model.Media
import javax.inject.Inject

class LoadVideosUseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
) : BaseUseCase<List<Media>>() {
    override suspend fun invoke(): List<Media> = domainRepository.updateVideos()

}