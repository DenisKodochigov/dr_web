package com.example.dr_web.presentation.ui.screens.package_list

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.dr_web.domain.usecase.GetPackagesUseCase
import com.example.dr_web.presentation.common.state.CommonViewModel
import com.example.dr_web.presentation.common.state.Event
import com.example.dr_web.presentation.common.state.ScreenState
import com.example.dr_web.presentation.ui.screens.package_list.model.PackagesConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PackagesViewModel @Inject constructor(
    private val useCase: GetPackagesUseCase,
    private val converter: PackagesConverter,):
    CommonViewModel<PackagesState, ScreenState<PackagesState>>() {

    override fun initState(): ScreenState<PackagesState> = ScreenState.Loading

    override fun handleEvent(argument: Event) {
        when (argument) {
            is PackagesEvent.GetPackages -> { getPackages() }
            is PackagesEvent.PackageClick -> { navigate.goToScreenPackage(argument.id) }
            is PackagesEvent.BackClick -> { navigate.backStack()}
        }
    }
    private fun getPackages() {
        viewModelScope.launch {
            useCase.execute(GetPackagesUseCase.Request(0))
                .map { converter.convert(it) }.collect { submitState(it) }
        }
    }
}

