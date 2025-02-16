package com.pb.compose_masterclass_android.todoApp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel() : ViewModel() {

    private val _todoListState = MutableStateFlow(TodoListState())
    val todoListState = _todoListState.asStateFlow()

    fun onAction(action: TodoEvents) {
        when (action) {
            is TodoEvents.OnCheckedChange -> {
                _todoListState.update {
                    it.copy(
                        todoList = it.todoList.map {
                            if(it == action.todo){
                                it.copy(
                                    isChecked = !it.isChecked
                                )
                            } else it
                        }
                    )
                }
            }
        }
    }
}

data class TodoListState(
    val todoList: List<Todo> = (1..15).map {
        Todo(
            title = "Todo item $it",
            description = "Description item $it",
            isChecked = false
        )
    },
    val newTodoTitle: String = "",
    val newTodoDesc: String = ""
)

sealed interface TodoEvents {
    data class OnCheckedChange(val todo: Todo) : TodoEvents
}