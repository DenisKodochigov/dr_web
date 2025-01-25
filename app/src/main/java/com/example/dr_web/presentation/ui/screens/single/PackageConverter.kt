package com.example.dr_web.presentation.ui.screens.single

import com.example.dr_web.domain.usecase.GetPackageUseCase
import com.example.dr_web.presentation.comon.state.CommonResultConverter
import javax.inject.Inject

class PackageConverter @Inject constructor() :
    CommonResultConverter<GetPackageUseCase.Response, PackageState>() {

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
