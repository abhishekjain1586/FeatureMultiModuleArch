package com.example.featuremultimoduleapp.articlesui.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.featuremultimoduleapp.articlesui.viewmodel.ArticlesViewModel
import com.example.featuremultimoduleapp.mediator.IMediator
import com.example.featuremultimoduleapp.uitheme.ui.theme.FeatureMultiModuleAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticlesActivity : ComponentActivity() {
    private val viewModel: ArticlesViewModel by viewModels()

    @Inject lateinit var appMediator: IMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        val d1 = Demo(age = 25, name = "Abhi")
        val d2 = d1.copy(age = 35, name = "Abhi")
        val d3 = d1.copy()
        val d4 = Demo(age = 25, name = "Abhi")
        val d5 = d4

        Log.d("testingggg", "ArticlesActivity - d1 hascode = ${d1.hashCode()}")
        Log.d("testingggg", "ArticlesActivity - d2 hascode = ${d2.hashCode()}")
        Log.d("testingggg", "ArticlesActivity - d3 hascode = ${d3.hashCode()}")
        Log.d("testingggg", "ArticlesActivity - d4 hascode = ${d4.hashCode()}")
        Log.d("testingggg", "ArticlesActivity - d5 hascode = ${d5.hashCode()}")

        Log.d("testingggg", "ArticlesActivity - d1 equals d2 = ${d1.equals(d2)}")
        Log.d("testingggg", "ArticlesActivity - d1 equals d3 = ${d1.equals(d3)}")
        Log.d("testingggg", "ArticlesActivity - d1 equals d4 = ${d1.equals(d4)}")
        Log.d("testingggg", "ArticlesActivity - d4 equals d5 = ${d4.equals(d5)}")

        Log.d("testingggg", "ArticlesActivity - d1 & d2 reference same = ${d1 === d2}")
        Log.d("testingggg", "ArticlesActivity - d1 & d3 reference same = ${d1 === d3}")
        Log.d("testingggg", "ArticlesActivity - d1 & d4 reference same = ${d1 === d4}")
        Log.d("testingggg", "ArticlesActivity - d4 & d5 reference same = ${d4 === d5}")

        setContent {
            FeatureMultiModuleAppTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                val uiState by viewModel.articles.collectAsState()
                Articles(state = uiState)
                //}
            }
        }
    }

    private fun launchLoginScreen() {
        /*ContextCompat.startActivity(
            this@MainActivity,
            Intent(this@MainActivity, LoginActivity::class.java),
            null
        )*/
    }
}

@Composable
fun Articles(
    state: ArticlesViewModel.UiState
) {
    /*Column {
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
    }*/
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FeatureMultiModuleAppTheme {
        Articles(state = ArticlesViewModel.UiState.Loading)
    }
}

data class Demo(
    val age: Int,
    val name: String
)