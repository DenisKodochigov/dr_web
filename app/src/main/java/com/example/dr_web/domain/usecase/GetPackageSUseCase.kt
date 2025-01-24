package com.example.dr_web.domain.usecase

import com.example.dr_web.domain.repository.PackageRepository
import com.example.dr_web.domain.entity.Package
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPackageSUseCase @Inject constructor(
    configuration: Configuration,
    private val packageRepository: PackageRepository
) : UseCase<GetPackageSUseCase.Request, GetPackageSUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> = packageRepository.getPackages().map { Response(it) }

    data class Request(val id: Long) : UseCase.Request
    data class Response(val applications: List<Package>) : UseCase.Response

}