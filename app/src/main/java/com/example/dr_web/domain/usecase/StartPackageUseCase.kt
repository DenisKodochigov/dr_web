package com.example.dr_web.domain.usecase

import android.content.Context
import android.content.pm.PackageManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StartPackageUseCase @Inject constructor(
    configuration: Configuration,
    private val context: Context,
    private val packageManager: PackageManager,
) : UseCase<StartPackageUseCase.Request, StartPackageUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> {

        val intent = packageManager.getLaunchIntentForPackage(request.pack)
        intent?.let { context.startActivity(intent) }

        return flow { emit(Response(0)) }
    }

    data class Request(val pack: String) : UseCase.Request
    data class Response(val packages: Int) : UseCase.Response

}