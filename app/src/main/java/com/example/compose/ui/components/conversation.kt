package com.example.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.compose.R

data class Sender(
    val name: String,
    val profile: Int
)

data class Message(
    val sender: Sender,
    val content: String
)

@Preview
@Composable
fun Conversation() {
    val messages = sequenceOf(
        Message(
            sender = Sender(
                name = "daryl",
                profile = R.drawable.ic_launcher_background
            ),
            content = "1 daryl 2 daryl 3 daryl, 1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl"
        ),
        Message(
            sender = Sender(
                name = "alan",
                profile = R.drawable.ic_launcher_background
            ),
            content = "1 daryl 2 daryl 3 daryl, 1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl1 daryl 2 daryl 3 daryl"
        ),
        Message(
            sender = Sender(
                name = "daryl",
                profile = R.drawable.ic_launcher_background
            ),
            content = "3"
        ),
        Message(
            sender = Sender(
                name = "alan",
                profile = R.drawable.ic_launcher_background
            ),
            content = "4"
        ),
    ).toList()

    LazyColumn {
        items(messages.size) { index ->
            MessageCard(messages.get(index))
        }
    }
}


@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Contact profile",
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(3.dp))
        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember {
            mutableStateOf(false)
        }

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded } ) {
            Text(
                text = message.content,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.body2
            )
        }
    }

}

//@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true, name = "LIGHT MODE")
//@Composable
//fun PreviewMessageCard() {
//    ComposeTheme {
//        MessageCard("abcd", "efgh")
//    }
//}
//
//@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, name = "NIGHT MODE")
//@Composable
//fun PreviewMessageCard(@PreviewParameter(NameProvider::class) names: String) {
//    ComposeTheme {
//        MessageCard(names)
//    }
//}
