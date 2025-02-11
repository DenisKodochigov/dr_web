package com.example.dr_web.presentation.ui.screens.package_single

import androidx.lifecycle.viewModelScope
import com.example.dr_web.domain.usecase.GetPackageUseCase
import com.example.dr_web.domain.usecase.StartPackageUseCase
import com.example.dr_web.presentation.comon.state.ScreenState
import com.example.dr_web.presentation.comon.state.MviViewModel
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
    MviViewModel<PackageState, ScreenState<PackageState>>() {

    override fun initState(): ScreenState<PackageState> = ScreenState.Loading

    val action = PackageAction(
        getPackage = { submitEvent(Arguments.GetPackage(it))},
        backScreen = { submitEvent(Arguments.BackClick)},
        packageRun = { submitEvent(Arguments.PackageRun(it))},
        initNavigate = { initNavigate(it) }
    )
    sealed class Arguments: UiArguments{
        data object BackClick : Arguments()
        data class GetPackage(val packageName: String) : Arguments()
        data class PackageRun(val packageName: String) : Arguments()
    }

    override fun handleEvent(action: UiArguments) {
        when (action) {
            is Arguments.GetPackage -> { getPackage(action.packageName) }
            is Arguments.BackClick -> { navigate.backStack()}
            is Arguments.PackageRun -> startPackage(action.packageName)
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