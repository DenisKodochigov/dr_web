package com.example.dr_web.presentation.comon.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dr_web.presentation.comon.navigation.NavigateEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class MviViewModel<T: Any, S: DataLoader<T>, A: UiAction>: ViewModel() {
    abstract fun initState(): S
    abstract fun handleAction(action: A)
    private val _dataStateFlow: MutableStateFlow<S> by lazy { MutableStateFlow(initState()) }
    val dataStateFlow: StateFlow<S> = _dataStateFlow
    private val actionFlow: MutableSharedFlow<A> = MutableSharedFlow()
    init { viewModelScope.launch { actionFlow.collect { handleAction(it) } } }
    lateinit var navigate: NavigateEvent
    fun initNavigate(navigateEvent: NavigateEvent) { navigate = navigateEvent}
    fun submitAction(action: A) { viewModelScope.launch { actionFlow.emit(action) } }
    fun submitState(state: S) { viewModelScope.launch { _dataStateFlow.value = state } }
}