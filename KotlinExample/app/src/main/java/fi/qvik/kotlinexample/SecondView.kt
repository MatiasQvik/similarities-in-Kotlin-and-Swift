package fi.qvik.kotlinexample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SecondView(name: String,
               goBack: () -> Unit) {
    Column {
        Text(text = "Second")
        Button(onClick = { goBack() }) {
            Text(text = "Back")
            
        }
    }
}