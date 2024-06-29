package com.example.featuremultimoduleapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.featuremultimoduleapp.articlesui.viewmodel.ArticlesViewModel
import com.example.featuremultimoduleapp.loginui.ui.LoginActivity
import com.example.featuremultimoduleapp.mediator.IMediator
import com.example.featuremultimoduleapp.uitheme.ui.theme.FeatureMultiModuleAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ArticlesViewModel by viewModels()

    @Inject lateinit var appMediator: IMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FeatureMultiModuleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        onClick = viewModel::getArticles,
                        onClickLogin = ::launchLoginScreen
                    )
                }
            }
        }

        viewModel.getArticles()
    }

    private fun launchLoginScreen() {
        ContextCompat.startActivity(
            this@MainActivity,
            Intent(this@MainActivity, LoginActivity::class.java),
            null
        )
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onClickLogin: () -> Unit = {}
) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Button(onClick = { onClick() }) {
            Text(
                text = "Get Articles",
                modifier = modifier
            )
        }
        Button(onClick = { onClickLogin() }) {
            Text(
                text = "Launch Login screen",
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FeatureMultiModuleAppTheme {
        Greeting("Android")
    }
}