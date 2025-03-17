package com.pb.compose_masterclass_android.sideEffects

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pb.compose_masterclass_android.compositionLocal.LocalSnackBarHostState
import com.pb.compose_masterclass_android.ui.theme.ComposemasterclassandroidTheme

@Composable
fun AutoScrollScreenRoot(modifier: Modifier = Modifier) {
    val viewModel = viewModel<AutoScrollViewModel>()

    AutoScrollScreen(
        modifier = modifier,
        listState = viewModel.lazyListState,
        snackBarHostState = viewModel.snackBarHostState,
        list = viewModel.getList()
    )
}

@Composable
fun AutoScrollScreen(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    snackBarHostState: SnackbarHostState,
    list: List<String>
) {

    Scaffold (
        snackbarHost = {
            SnackbarHost(
                hostState = LocalSnackBarHostState.current
            )
        }
    ){ innerPadding ->
        LazyColumn(
            state = listState,
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(list) { item ->
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = item,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AutoScrollScreenPreview() {
    ComposemasterclassandroidTheme {
        AutoScrollScreen(
            snackBarHostState = SnackbarHostState(),
            listState = LazyListState(),
            list = listOf("Apple", "Banana", "Cat")
        )
    }
}