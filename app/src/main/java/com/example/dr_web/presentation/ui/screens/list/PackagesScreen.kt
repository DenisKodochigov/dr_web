package com.example.dr_web.presentation.ui.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
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
            PackageList( dataState,
                { item -> vm.submitAction(PackagesAction.PackageClick(item.id)) },
                { item -> vm.submitAction(PackagesAction.PackageClick(item.id)) })
        }
    }
}

@Composable
fun PackageList(
    dataState: PackagesState,
    onRowClick: (PackageModel) -> Unit,
    onAuthorClick: (PackageModel) -> Unit,
) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item(dataState.headerText) {
            Column(modifier = Modifier.padding(16.dp)) { Text(text = dataState.headerText) }
        }
        items(dataState.items) { item ->
            Column(modifier = Modifier.padding(16.dp).clickable { onRowClick(item) }) {
                Text(text = AnnotatedString(text = item.title),
                    modifier = Modifier.clickable { onAuthorClick(item) })
                Text(text = item.body)
            }
        }
    }
}