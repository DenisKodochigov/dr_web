package com.example.dr_web.presentation.ui.screens.list

import com.example.dr_web.domain.usecase.GetPackagesUseCase
import com.example.dr_web.presentation.comon.state.CommonResultConverter
import javax.inject.Inject

class PackagesConverter @Inject constructor() :
    CommonResultConverter<GetPackagesUseCase.Response, PackagesState>() {

    override fun convertSuccess(data: GetPackagesUseCase.Response): PackagesState {
        return PackagesState(
            headerText = "",
            items = data.packages.map{
                PackagesItemModel(
                    name = it.name,
                    hash = it.hash,
                    icon = it.icon,
                    packageName = it.packages) }.sortedBy { it.name }
        )
    }
}
