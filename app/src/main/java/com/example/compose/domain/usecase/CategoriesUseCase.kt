package com.example.compose.domain.usecase

import com.example.compose.data.DomainRepositoryImpl
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl,
    ) : BaseUseCase<MutableList<String>>() {
    override suspend fun invoke(): MutableList<String> = domainRepository.updateCategories(DomainRepositoryImpl.query)
}