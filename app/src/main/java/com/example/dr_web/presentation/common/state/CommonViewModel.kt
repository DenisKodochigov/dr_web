package com.example.dr_web.presentation.common.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dr_web.presentation.common.navigation.NavigateEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class CommonViewModel<T: Any, S: ScreenState<T>>: ViewModel() {
    abstract fun initState(): S
    abstract fun handleEvent(action: Event)

    private val eventFlow: MutableSharedFlow<Event> = MutableSharedFlow()
    private val _dataStateFlow: MutableStateFlow<S> by lazy { MutableStateFlow(initState()) }
    val dataStateFlow: StateFlow<S> = _dataStateFlow

    lateinit var navigate: NavigateEvent

    init { viewModelScope.launch { eventFlow.collect { handleEvent(it) } } }

    fun initNavigate(navigateEvent: NavigateEvent) { navigate = navigateEvent}
    fun submitEvent(event: Event) { viewModelScope.launch { eventFlow.emit(event) } }
    fun submitState(state: S) { viewModelScope.launch { _dataStateFlow.value = state } }
}