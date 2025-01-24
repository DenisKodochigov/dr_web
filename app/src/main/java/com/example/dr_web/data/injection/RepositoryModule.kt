package com.example.dr_web.data.injection


import com.example.dr_web.data.repository.PackageRepositoryImpl
import com.example.dr_web.domain.repository.PackageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPackageRepository(packageRepoImpl: PackageRepositoryImpl): PackageRepository
}