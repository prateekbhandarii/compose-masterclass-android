package com.pb.compose_masterclass_android.responsiveUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pb.compose_masterclass_android.ui.theme.ComposemasterclassandroidTheme

@Composable
fun ListItemContent(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Magenta)
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Row {
            Icon(
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = null,
                tint = Color.White
            )

            Row {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    text = "Project X",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        Text(
            text = "Feel free to play around with specific spacing values until it looks as on the mockups. It doesn't have to be pixel-perfect, but make sure that the size & position relations match.\n" +
                    "You can clip a Composable with the clip(RoundedCornerShape(5.dp)) Modifier or alternatively clip(CircleShape). If you need help with that check the video about clipping in the Basic Modifiers section.",
            modifier = Modifier
                .padding(top = 10.dp, start = 38.dp),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.White
            )
        )

        Text(
            modifier = Modifier.align(Alignment.End),
            text = "Feb 16 2025",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ListItemContentPreview() {
    ComposemasterclassandroidTheme {
        ListItemContent()
    }
}