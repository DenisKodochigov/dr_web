package com.example.dr_web.presentation.ui.screens.package_single

import android.R.attr.action
import android.R.attr.data
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.example.dr_web.presentation.common.navigation.NavigateEventImpl
import com.example.dr_web.presentation.common.state.Action
import com.example.dr_web.presentation.common.state.PrimeScreen
import com.example.dr_web.presentation.common.state.ScreenState
import com.example.dr_web.presentation.ui.screens.package_list.PackagesEvent
import com.example.dr_web.presentation.ui.screens.package_list.PackagesState
import com.example.dr_web.presentation.ui.screens.package_list.PackagesViewModel
import kotlinx.coroutines.flow.StateFlow

class PackagesScreenCl ( val vm: PackagesViewModel, navigateEvent: NavigateEventImpl
): PrimeScreen<PackagesState>() {
    val state: StateFlow<ScreenState<PackagesState>> = vm.dataStateFlow
    val action = Action{ vm.submitEvent(it) }
    init { vm.initNavigate(navigateEvent) }

    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    fun ScreenView() {
        LaunchedEffect(Unit) { action.ex(PackagesEvent.GetPackages)}
        val st = vm.dataStateFlow.collectAsState().value
        super.ScreenView(st){ state->
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                item(state.headerText) {
                    Column(modifier = Modifier.padding(16.dp)) { Text(text = state.headerText) } }
                items(state.items){ item->
                    Row (verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                            .clickable { action.ex(PackagesEvent.PackageClick(item.packageName))})
                    {
                        item.icon?.let {
                            Image( bitmap = it.toBitmap(width = 120, height = 120, null).asImageBitmap(),
                                "", modifier = Modifier.padding(end = 12.dp),) }
                        Text(text = AnnotatedString(text = item.name), )
                    }
                }
            }
        }
    }
}