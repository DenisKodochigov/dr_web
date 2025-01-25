package com.example.dr_web.presentation.ui.screens.list

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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dr_web.presentation.comon.navigation.NavigateEventImpl
import com.example.dr_web.presentation.comon.state.CommonScreen

@Composable
fun PackagesScreen(navigateEvent: NavigateEventImpl) {
    val vm: PackagesViewModel = hiltViewModel()
    vm.initNavigate(navigateEvent)
    LaunchedEffect(Unit) { vm.submitAction(PackagesAction.GetPackages) }
    vm.dataStateFlow.collectAsState().value.let { dataLoader ->
        CommonScreen( loader = dataLoader ) { dataState->
            PackageList( dataState){ item ->
                vm.submitAction(PackagesAction.PackageClick(item.packageName)) }
        }
    }
}

@Composable fun PackageList(dataState: PackagesState, onRowClick: (PackagesItemModel) -> Unit, ) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item(dataState.headerText) {
            Column(modifier = Modifier.padding(16.dp)) { Text(text = dataState.headerText) }
        }
        items(dataState.items) { item ->
            Row( verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp).clickable { onRowClick(item) }) {
                item.icon?.let {
                    Image( bitmap = it.toBitmap(width = 120, height = 120, null).asImageBitmap(),
                        "", modifier = Modifier.padding(end = 12.dp),) }
                Text(text = AnnotatedString(text = item.name), )
            }
        }
    }
}