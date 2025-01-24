package com.example.dr_web.domain.di

import com.example.dr_web.domain.repository.PackageRepository
import com.example.dr_web.domain.usecase.GetPackageSUseCase
import com.example.dr_web.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCaseConfiguration(): UseCase.Configuration = UseCase.Configuration(Dispatchers.IO)

    @Provides
    fun provideGetPackagesUseCase(configuration: UseCase.Configuration,
        packageRepo: PackageRepository): GetPackageSUseCase = GetPackageSUseCase(configuration, packageRepo)
}