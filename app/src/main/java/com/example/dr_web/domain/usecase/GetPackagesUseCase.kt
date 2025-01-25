package com.example.dr_web.domain.usecase

import com.example.dr_web.domain.repository.PackageRepository
import com.example.dr_web.domain.entity.Package
import com.example.dr_web.domain.entity.Packages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPackagesUseCase @Inject constructor(
    configuration: Configuration,
    private val packageRepository: PackageRepository
) : UseCase<GetPackagesUseCase.Request, GetPackagesUseCase.Response>(configuration) {

    private var packageList: List<Package> = emptyList()
    override fun process(request: Request): Flow<Response> {
        val result = if (packageList.isEmpty()){
            packageRepository.getPackages().map {
                    packageList = it
                    Response(it)
                }
            } else { flow { emit(Response(packageList)) } }
        return result
    }

    data class Request(val id: Long) : UseCase.Request
    data class Response(val packages: List<Package>) : UseCase.Response

}