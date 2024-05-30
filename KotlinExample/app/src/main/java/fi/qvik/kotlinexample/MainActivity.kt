package fi.qvik.kotlinexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import fi.qvik.kotlinexample.ui.theme.KotlinExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinExampleTheme {
                // A surface container using the 'background' color from the theme
                NavigationView()
            }
        }
    }
}
