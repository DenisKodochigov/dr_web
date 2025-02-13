package com.example.dr_web.presentation.ui.screens.package_single

import androidx.lifecycle.viewModelScope
import com.example.dr_web.domain.usecase.GetPackageUseCase
import com.example.dr_web.domain.usecase.StartPackageUseCase
import com.example.dr_web.presentation.common.state.ScreenState
import com.example.dr_web.presentation.common.state.CommonViewModel
import com.example.dr_web.presentation.common.state.Event
import com.example.dr_web.presentation.ui.screens.package_single.model.PackageConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PackageViewModel @Inject constructor(
    private val getPackageUseCase: GetPackageUseCase,
    private val startPackageUseCase: StartPackageUseCase,
    private val converter: PackageConverter,):
    CommonViewModel<PackageState, ScreenState<PackageState>>() {

    override fun initState(): ScreenState<PackageState> = ScreenState.Loading

    override fun handleEvent(action: Event) {
        when (action) {
            is PackageEvent.GetPackage -> { getPackage(action.packageName) }
            is PackageEvent.BackClick -> { navigate.backStack()}
            is PackageEvent.RunPackage -> startPackage(action.packageName)
        }
    }
    private fun getPackage(packageName: String) {
        viewModelScope.launch {
            getPackageUseCase.execute(GetPackageUseCase.Request(packageName))
                .map { converter.convert(it) }.collect { submitState(it) }
        }
    }
    private fun startPackage(packageName: String) {
        viewModelScope.launch {
            startPackageUseCase.execute(StartPackageUseCase.Request(packageName))
        }
    }
}