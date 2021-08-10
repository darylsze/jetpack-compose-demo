package com.example.compose.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.theme.ComposeTheme

data class Sender(
    val name: String,
    val profile: Int
)

data class Message(
    val sender: Sender,
    val content: String
)

@Preview(uiMode = UI_MODE_NIGHT_NO)
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
    ComposeTheme(false) {
        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember {
            mutableStateOf(false)
        }

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
            Column(
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded }
                    .padding(5.dp)
                    .background(androidx.compose.ui.graphics.Color.White)
                    .clip(RoundedCornerShape(10))
            ) {
                Text(
                    text = message.sender.name,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                )
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
