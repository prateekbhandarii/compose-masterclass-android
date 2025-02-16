package com.pb.compose_masterclass_android.todoApp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pb.compose_masterclass_android.ui.theme.ComposemasterclassandroidTheme

@Composable
fun TodoListItem(
    modifier: Modifier = Modifier,
    data: Todo,
    onTaskCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = data.title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textDecoration = if (data.isChecked) {
                        TextDecoration.LineThrough
                    } else {
                        TextDecoration.None
                    }
                )
            )

            Text(
                text = data.description,
                style = TextStyle(
                    fontSize = 16.sp,
                    textDecoration = if (data.isChecked) {
                        TextDecoration.LineThrough
                    } else {
                        TextDecoration.None
                    }
                )
            )
        }

        Checkbox(
            checked = data.isChecked,
            onCheckedChange = {
                onTaskCheckedChange(it)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoListItemPreview() {
    ComposemasterclassandroidTheme {
        TodoListItem(
            data = Todo(
                title = "Bring out the trash",
                description = "Better to do before your wife comes home.",
                isChecked = true
            ),
            onTaskCheckedChange = {}
        )
    }
}