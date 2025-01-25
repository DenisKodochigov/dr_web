package com.example.dr_web.presentation.ui.screens.single

import androidx.lifecycle.viewModelScope
import com.example.dr_web.domain.usecase.GetPackageUseCase
import com.example.dr_web.domain.usecase.StartPackageUseCase
import com.example.dr_web.presentation.comon.state.DataLoader
import com.example.dr_web.presentation.comon.state.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PackageViewModel @Inject constructor(
    private val getPackageUseCase: GetPackageUseCase,
    private val startPackageUseCase: StartPackageUseCase,
    private val converter: PackageConverter,):
    MviViewModel<PackageState, DataLoader<PackageState>, PackageAction>() {

    override fun initState(): DataLoader<PackageState> = DataLoader.Loading

    override fun handleAction(action: PackageAction) {
        when (action) {
            is PackageAction.GetPackage -> { getPackage(action.packageName) }
            is PackageAction.BackClick -> { navigate.backStack()}
            is PackageAction.StartPackage -> startPackage(action.packageName)
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