package com.pb.compose_masterclass_android.sideEffects

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AutoScrollViewModel : ViewModel() {

    val lazyListState = LazyListState()
    val snackBarHostState = SnackbarHostState()

    init {
        snapshotFlow {
            val layoutInfo = lazyListState.layoutInfo
            layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
        }.onEach { aBoolean ->
            if (aBoolean) {
                snackBarHostState.showSnackbar("Scrolled to bottom!")
            }
        }.launchIn(viewModelScope)
    }

    fun getList(): List<String> {
        val list: MutableList<String> = mutableListOf()
        for (i in 1..50) {
            list.add("Item $i")
        }
        return list
    }
}