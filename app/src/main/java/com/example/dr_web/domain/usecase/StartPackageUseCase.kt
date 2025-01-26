package com.example.dr_web.domain.usecase

import com.example.dr_web.domain.repository.PackageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StartPackageUseCase @Inject constructor(
    configuration: Configuration,
    private val packageRepository: PackageRepository
) : UseCase<StartPackageUseCase.Request, StartPackageUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> {
        packageRepository.startPackage(request.pack)
        return flow { emit(Response(0)) }
    }

    data class Request(val pack: String) : UseCase.Request
    data class Response(val packages: Int) : UseCase.Response

}