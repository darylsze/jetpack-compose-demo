package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose.ui.components.Message
import com.example.compose.ui.components.MessageCard
import com.example.compose.ui.components.Sender

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(
                Message(
                    sender = Sender(
                        name = "darylv2",
                        profile = R.drawable.ic_launcher_background
                    ),
                    content = "hi, hihihihihihihihi,hihihihihihihihihihihihihihihihihihihihi,hihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihihi"
                )
            )
        }
    }

}
