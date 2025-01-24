package com.example.dr_web.presentation.ui.screens.list

import androidx.lifecycle.viewModelScope
import com.example.dr_web.domain.usecase.GetPackageSUseCase
import com.example.dr_web.presentation.comon.state.DataLoader
import com.example.dr_web.presentation.comon.state.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PackagesViewModel @Inject constructor(
    private val useCase: GetPackageSUseCase,
    private val converter: PackagesConverter,):
    MviViewModel<PackagesState, DataLoader<PackagesState>, PackagesAction>() {
//class PackagesViewModel @Inject constructor():MviViewModel<T: Any, S: DataLoader<T>, A: UiAction>
//    private val _uiStateFlow: MutableStateFlow<S> by lazy { MutableStateFlow(initState()) }
//    val uiStateFlow: StateFlow<S> = _uiStateFlow
//    private val _uiStateFlow: MutableStateFlow<DataLoader<PackagesState>> by lazy { MutableStateFlow(initState())
//    val uiStateFlow: StateFlow<DataLoader<PackagesState>> = _uiStateFlow
//    private val actionFlow: MutableSharedFlow<A> = MutableSharedFlow()
//    init { viewModelScope.launch { actionFlow.collect { handleAction(it) } } }
//    fun submitAction(action: A) { viewModelScope.launch { actionFlow.emit(action) } }
//    fun submitState(state: S) { viewModelScope.launch { _uiStateFlow.value = state } }

    override fun initState(): DataLoader<PackagesState> = DataLoader.Loading
    override fun handleAction(action: PackagesAction) {
        when (action) {
            is PackagesAction.GetPackages -> { getPackages() }
            is PackagesAction.PackageClick -> { navigate.goToScreenPackage(action.id) }
            is PackagesAction.BackClick -> { navigate.backStack()}
        }
    }
    private fun getPackages() {
        viewModelScope.launch {
//            useCase.execute(GetPackageSUseCase.Request(0))
//                .map { converter.convert(it) }
//                .collect { submitState(it) }
        }
    }
}