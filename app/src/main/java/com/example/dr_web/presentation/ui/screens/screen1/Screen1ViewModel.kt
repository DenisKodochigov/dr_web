package com.example.dr_web.presentation.ui.screens.screen1

//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.catch
//import kotlinx.coroutines.flow.combine
//import kotlinx.coroutines.flow.filterNotNull
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.map
//import kotlinx.coroutines.flow.onStart
//import kotlinx.coroutines.flow.scan
//
//class Screen1ViewModel: ViewModel() {
//    private val _intents: MutableStateFlow<FeedIntent?> = MutableStateFlow(null)
//    private val _viewStates: MutableStateFlow<FeedViewState> = MutableStateFlow(FeedViewState.initial)
//
//    init {
//        _intents.filterNotNull().toProcessor().toResult()
//            .toViewState().onEach { _viewStates.value = it }.launchIn(viewModelScope)
//    }
//    fun processIntent(intent: FeedIntent) { _intents.value = intent }
//    fun viewStates(): Flow<FeedViewState> = _viewStates
//}
//
//data class FeedArticle( val head: String, val body: String, val uuid: String)
//sealed class FeedIntent {
//    object Initial : FeedIntent() // When user just opens the screen.
//    object Refresh : FeedIntent()
//    class AddToFavorite(val article: FeedArticle) : FeedIntent()
//    class RemoveFromFavorite(val article: FeedArticle) : FeedIntent()
//    class Open(val article: FeedArticle) : FeedIntent()
//}
//
//fun Flow<FeedIntent>.toProcessor(): Flow<FeedProcessor> = map { intent ->
//    when (intent) {
//        FeedIntent.Initial, FeedIntent.Refresh -> FeedProcessor.LoadArticles
//        is FeedIntent.AddToFavorite -> FeedProcessor.AddToFavorite(intent.article)
//        is FeedIntent.RemoveFromFavorite -> FeedProcessor.RemoveFromFavorite(intent.article)
//        is FeedIntent.Open -> FeedProcessor.Open(intent.article)
//    }
//}
//fun Flow<FeedProcessor>.toResult(): Flow<FeedResult> = map { it.process() }
//fun Flow<FeedResult>.toViewState(): Flow<FeedViewState> =
//    scan(FeedViewState.initial) { acc, result ->
//        when (result) {
//            FeedResult.Loading -> acc.copy(isLoading = true)
//            is FeedResult.ArticlesLoaded -> acc.copy(
//                isLoading = false,
//                articles = result.articles,
//                favorites = result.favorites.toSet()
//            )
//            is FeedResult.ArticleAddedToFavorites -> acc.copy(
//                favorites = acc.favorites.plus(result.article.uuid))
//            is FeedResult.ArticleRemovedFromFavorites -> acc.copy(
//                favorites = acc.favorites.minus(result.article.uuid))
//            is FeedResult.Error -> acc.copy(
//                isLoading = false,
//                error = result.error
//            )
//        }
//    }
//
//sealed class FeedProcessor {
//    abstract suspend fun process(): Flow<FeedResult>
//    object LoadArticles : FeedProcessor() {
//        override suspend fun process(): Flow<FeedResult> =
//            combine<List<FeedArticle>, List<String>, FeedResult> (loadArticles(), loadFavorites()){
//                    articles, favorites -> FeedResult.ArticlesLoaded(articles, favorites) }
//                .onStart { emit(FeedResult.Loading) }
//                .catch { emit( FeedResult.Error(it)) }
//    }
//    data class AddToFavorite(val article: FeedArticle): FeedProcessor(){
//        override suspend fun process(): Flow<FeedResult> {
//            TODO("Not yet implemented")
//        }
//    }
//    data class RemoveFromFavorite(val article: FeedArticle): FeedProcessor(){
//        override suspend fun process(): Flow<FeedResult> {
//            TODO("Not yet implemented")
//        }
//    }
//    data class Open(val article: FeedArticle): FeedProcessor(){
//        override suspend fun process(): Flow<FeedResult> {
//            TODO("Not yet implemented")
//        }
//    }
//    // ...
//}
//sealed class FeedResult {
//    object Loading : FeedResult()
//    class ArticlesLoaded(val articles: List<FeedArticle>, val favorites: List<String>): FeedResult()
//    class ArticleAddedToFavorites(val article: FeedArticle): FeedResult()
//    class ArticleRemovedFromFavorites(val article: FeedArticle): FeedResult()
//    class Error(val error: Throwable) : FeedResult()
//}
//data class FeedViewState(
//    val isLoading: Boolean,
//    val articles: List<FeedArticle>,
//    val favorites: Set<String>,
//    val error: Throwable?
//) {
//    companion object {
//        // The state when user just launches the screen.
//        val initial = FeedViewState(
//            isLoading = false,
//            articles = emptyList(),
//            favorites = emptySet(),
//            error = null
//        )
//    }
//}
//fun loadArticles(): Flow<List<FeedArticle>> = flow { emit( emptyList<FeedArticle>()) }
//fun loadFavorites(): Flow<List<String>> = flow { emit( emptyList<String>()) }