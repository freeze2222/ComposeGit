package com.example.compose.domain.usecase

abstract class BaseUseCase<T> {
    abstract suspend fun invoke(): T
}