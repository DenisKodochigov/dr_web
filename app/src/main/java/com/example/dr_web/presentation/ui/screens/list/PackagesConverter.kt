package com.example.dr_web.presentation.ui.screens.list

import com.example.dr_web.domain.usecase.GetPackageSUseCase
import com.example.dr_web.presentation.comon.state.CommonResultConverter
import javax.inject.Inject

class PackagesConverter @Inject constructor() :
    CommonResultConverter<GetPackageSUseCase.Response, PackagesState>() {

    override fun convertSuccess(data: GetPackageSUseCase.Response): PackagesState {
        return PackagesState(
            headerText = "",
            items = data.applications.map{ PackageModel(title = it.name, body = it.par1, id = it.id,) }
        )
    }
}
