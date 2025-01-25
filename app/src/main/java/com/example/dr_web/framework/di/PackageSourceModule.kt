package com.example.dr_web.framework.di

import com.example.dr_web.data.source.PackageSource
import com.example.dr_web.framework.services.source.PackageSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PackageSourceModule {
    @Binds
    abstract fun bindPackageSource(setSource: PackageSourceImpl): PackageSource
}