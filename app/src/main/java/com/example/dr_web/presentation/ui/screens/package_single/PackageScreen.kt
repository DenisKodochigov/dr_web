package com.example.dr_web.presentation.ui.screens.package_single

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dr_web.presentation.comon.navigation.NavigateEventImpl
import com.example.dr_web.presentation.comon.state.CommonScreen

@Composable
fun PackageScreen(navigateEvent: NavigateEventImpl, packageName: String) {
    val vm: PackageViewModel = hiltViewModel()
    val action = vm.action
    action.initNavigate(navigateEvent)
    LaunchedEffect(Unit) { action.getPackage(packageName) }
    vm.dataStateFlow.collectAsState().value.let { dataLoader ->
        CommonScreen( loader = dataLoader ) { dataState->
            PackageList(dataState) { action.packageRun( dataState.item.packageName)}
        }
    }
}

@Composable fun PackageList(dataState: PackageState, onClick:()->Unit ) {
    Column( horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        dataState.item.icon?.let {
            Image( bitmap = it.toBitmap(width = 400, height = 400, null).asImageBitmap(),
                "", modifier = Modifier.padding(end = 24.dp).clickable { onClick() },)
        }
        RowViewParameter("Name", dataState.item.name)
        RowViewParameter("Package name", dataState.item.packageName)
        RowViewParameter("Version", dataState.item.version)
        RowViewParameter("CRC", dataState.item.crc)
    }
}
@Composable fun RowViewParameter(head: String, body: String){

    Column( modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),) {
        Text(text = "$head : ", style = MaterialTheme.typography.bodyMedium)
        Text(text = body, modifier = Modifier.padding(start = 24.dp,),
            style = MaterialTheme.typography.bodyMedium)
    }

}