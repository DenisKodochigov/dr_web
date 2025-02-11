package com.example.dr_web.presentation.ui.screens.package_single.model

import com.example.dr_web.domain.usecase.GetPackageUseCase
import com.example.dr_web.presentation.comon.state.CommonConverter
import com.example.dr_web.presentation.ui.screens.package_single.PackageState
import javax.inject.Inject

class PackageConverter @Inject constructor() :
    CommonConverter<GetPackageUseCase.Response, PackageState>() {

    override fun convertSuccess(data: GetPackageUseCase.Response): PackageState {
        return PackageState(
            headerText = "",
            item = PackageModel(
                icon = data.pack.icon, name = data.pack.name,
                packageName = data.pack.packages,
                crc = data.pack.crc,
                version = data.pack.version
            )
        )
    }
}
