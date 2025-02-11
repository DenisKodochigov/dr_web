package com.example.dr_web.presentation.ui.screens.package_list

import androidx.lifecycle.viewModelScope
import com.example.dr_web.domain.usecase.GetPackagesUseCase
import com.example.dr_web.presentation.comon.state.MviViewModel
import com.example.dr_web.presentation.comon.state.ScreenState
import com.example.dr_web.presentation.ui.screens.package_list.model.PackagesConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PackagesViewModel @Inject constructor(
    private val useCase: GetPackagesUseCase,
    private val converter: PackagesConverter,):
    MviViewModel<PackagesState, ScreenState<PackagesState>>() {

    override fun initState(): ScreenState<PackagesState> = ScreenState.Loading
    val action = PackagesAction(
        getPackages = { submitEvent(Arguments.GetPackages)},
        backScreen = { submitEvent(Arguments.BackClick)},
        packageClick = { submitEvent(Arguments.PackageClick(it))},
        initNavigate = { initNavigate(it) }
    )
    sealed class Arguments: UiArguments{
        data object GetPackages : Arguments()
        data object BackClick : Arguments()
        data class PackageClick(val id: String) : Arguments()
    }

    override fun handleEvent(argument: UiArguments) {
        when (argument) {
            is Arguments.GetPackages -> { getPackages() }
            is Arguments.PackageClick -> { navigate.goToScreenPackage(argument.id) }
            is Arguments.BackClick -> { navigate.backStack()}
        }
    }
    private fun getPackages() {
        viewModelScope.launch {
            useCase.execute(GetPackagesUseCase.Request(0))
                .map { converter.convert(it) }.collect { submitState(it) }
        }
    }
}

