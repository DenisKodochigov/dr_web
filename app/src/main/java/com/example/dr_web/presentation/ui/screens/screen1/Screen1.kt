package com.example.dr_web.presentation.ui.screens.screen1


//class MainAct {
//
//    fun intents(): Flow<FeedIntent> = merge(
//        initialIntent(),
//        refreshIntent(),
////        addToFavoriteIntent(),
////        removeFromFavoriteIntent(),
////        openArticleIntent()
//    )
//    fun onCreate(savedInstanceState: Bundle?) {
//        intents()
//            .toProcessor()
//            .process()
//            .toViewState()
//            .render()
//            .launchIn(lifecycleScope)
//
//        lifecycleScope.launchWhenStarted {
//            intents().collect(feedViewModel::processIntent)
//        }
//        lifecycleScope.launchWhenStarted {
//            feedViewModel.viewStates().collect(::render)
//        }
//    }
//    private fun initialIntent(): Flow<FeedIntent> = flowOf(FeedIntent.Initial)
//
//    private fun refreshIntent(): Flow<FeedIntent> = callbackFlow {
//        swipeRefreshLayout.setOnRefreshListener { trySend(FeedIntent.Refresh) }
//        awaitClose()
//    }
//    fun render(state: FeedViewState) {
//        swipeRefreshLayout.isRefreshing = state.isLoading
//    }
//}

//
//@Composable
//fun Screen1(navigateEvent: NavigateEventImpl) {
//
//    val vm: PackagesViewModel = hiltViewModel()
//    val action = vm.action
//    action.initNavigate(navigateEvent)
//    LaunchedEffect(Unit) { action.getPackages() }
//    vm.dataStateFlow.collectAsState().value.let { dataLoader ->
//        CommonScreen( loader = dataLoader ) { dataState->
//            PackageList( dataState){ item -> action.packageClick(item.packageName)}
//        }
//    }
//}
//
//@Composable fun PackageList(dataState: PackagesState, onRowClick: (PackagesItemModel) -> Unit, ) {
//    LazyColumn(modifier = Modifier.padding(16.dp)) {
//        item(dataState.headerText) {
//            Column(modifier = Modifier.padding(16.dp)) { Text(text = dataState.headerText) }
//        }
//        items(dataState.items) { item ->
//            Row( verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(16.dp).clickable { onRowClick(item) }) {
//                item.icon?.let {
//                    Image( bitmap = it.toBitmap(width = 120, height = 120, null).asImageBitmap(),
//                        "", modifier = Modifier.padding(end = 12.dp),) }
//                Text(text = AnnotatedString(text = item.name), )
//            }
//        }
//    }
//}