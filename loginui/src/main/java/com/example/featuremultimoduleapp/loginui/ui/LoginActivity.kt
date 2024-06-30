package com.example.featuremultimoduleapp.loginui.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.featuremultimoduleapp.loginui.R
import com.example.featuremultimoduleapp.mediator.IMediator
import com.example.featuremultimoduleapp.uitheme.ui.theme.FeatureMultiModuleAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    @Inject lateinit var appMediator: IMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        setContent {
            FeatureMultiModuleAppTheme {
                LoginScreen(onLogin = ::launchArticles)
            }
        }

        /*findViewById<Button>(R.id.btnLaunch).setOnClickListener {
            appNavigator.navigateToArticles()
        }*/
    }

    private fun launchArticles() {
        appMediator.navigateToArticles(this)
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLogin: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = "Username",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextField(value = "a@a.com", onValueChange = {})
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = "Pass",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextField(value = "test", onValueChange = {})
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { onLogin() }) {
            Text(
                text = "Login",
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    FeatureMultiModuleAppTheme {
        LoginScreen()
    }
}