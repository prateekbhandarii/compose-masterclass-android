package com.pb.compose_masterclass_android.todoApp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pb.compose_masterclass_android.ui.theme.ComposemasterclassandroidTheme

@Composable
fun TodoListScreenRoot(modifier: Modifier = Modifier) {

    val viewModel = viewModel<TodoViewModel>()
    val listState by viewModel.todoListState.collectAsStateWithLifecycle()

    TodoListScreen(
        modifier = modifier,
        todoListState = listState,
        onAction = viewModel::onAction
    )
}

@Composable
fun TodoListScreen(
    modifier: Modifier = Modifier,
    todoListState: TodoListState,
    onAction: (TodoEvents) -> Unit
) {
    Scaffold (
        floatingActionButton = {

        }
    ){ innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(todoListState.todoList) { todo ->
                TodoListItem(
                    data = todo,
                    onTaskCheckedChange = {
                        onAction(TodoEvents.OnCheckedChange(todo))
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun TodoListScreenPreview() {
    ComposemasterclassandroidTheme {
        TodoListScreen(
            todoListState = TodoListState(),
            onAction = {}
        )
    }
}