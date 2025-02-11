package com.example.dr_web.presentation.comon.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dr_web.presentation.comon.navigation.NavigateEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class MviViewModel<T: Any, S: ScreenState<T>>: ViewModel() {
    interface UiArguments
    abstract fun initState(): S
    abstract fun handleEvent(action: UiArguments)

    private val _dataStateFlow: MutableStateFlow<S> by lazy { MutableStateFlow(initState()) }
    val dataStateFlow: StateFlow<S> = _dataStateFlow

    private val eventFlow: MutableSharedFlow<UiArguments> = MutableSharedFlow()
    lateinit var navigate: NavigateEvent

    init { viewModelScope.launch { eventFlow.collect { handleEvent(it) } } }

    fun initNavigate(navigateEvent: NavigateEvent) { navigate = navigateEvent}
    fun submitEvent(event: UiArguments) { viewModelScope.launch {eventFlow.emit(event) } }
    fun submitState(state: S) { viewModelScope.launch { _dataStateFlow.value = state } }
}