package fi.qvik.kotlinexample

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ContentView(
    goToSecondView: (String) -> Unit
) {
    val name = remember {
        mutableStateOf("Qvik")
    }
    val isLoading = remember {
        mutableStateOf(false)
    }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_hd_24),
                contentDescription = "Ultra HD 4K"
            )
            Text(text = "Hello, ${name.value}!")
            if (isLoading.value) {
                CircularProgressIndicator()
            } else {
                Button(onClick = {
                    isLoading.value = true
                    coroutineScope.launch {
                        try {
                            name.value = getName()
                            isLoading.value = false
                        } catch (e: Exception) {
                            Log.d("ContentView", "Error", e)
                        }
                    }
                }) {
                    Text(text = name.value)
            }
        }
        Button(onClick = {goToSecondView(name.value)}) {
            Text(text = "Next View")
        }
    }
}

suspend fun getName(): String {
    delay(500L)
    return "New name"
    
}

@Preview
@Composable
private fun ContentViewPreview() {
    ContentView(goToSecondView = {})
}