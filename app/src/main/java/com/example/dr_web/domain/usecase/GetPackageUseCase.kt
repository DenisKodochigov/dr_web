package com.example.dr_web.domain.usecase

import com.example.dr_web.domain.repository.PackageRepository
import com.example.dr_web.domain.entity.Package
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject

class GetPackageUseCase @Inject constructor(
    configuration: Configuration,
    private val packageRepository: PackageRepository
) : UseCase<GetPackageUseCase.Request, GetPackageUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> {
        val result = packageRepository.getPackage(request.packageName).map { Response(it) }
        return result
    }
    data class Request(val packageName: String) : UseCase.Request
    data class Response(val pack: Package) : UseCase.Response
}