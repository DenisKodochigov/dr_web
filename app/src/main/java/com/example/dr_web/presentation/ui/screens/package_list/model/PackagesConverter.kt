package com.example.dr_web.presentation.ui.screens.package_list.model

import com.example.dr_web.domain.usecase.GetPackagesUseCase
import com.example.dr_web.presentation.common.state.CommonConverter
import com.example.dr_web.presentation.ui.screens.package_list.PackagesState
import javax.inject.Inject

class PackagesConverter @Inject constructor() :
    CommonConverter<GetPackagesUseCase.Response, PackagesState>() {

    override fun convertSuccess(data: GetPackagesUseCase.Response): PackagesState {
        return PackagesState(
            headerText = "",
            items = data.packages.map {
                PackagesItemModel(
                    name = it.name,
                    hash = it.hash,
                    icon = it.icon,
                    packageName = it.packages
                )
            }.sortedBy { it.name }
        )
    }
}
