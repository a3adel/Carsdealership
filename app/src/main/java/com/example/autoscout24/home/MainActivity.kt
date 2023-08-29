package com.example.autoscout24.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.autoscout24.R
import com.example.autoscout24.home.composeComponents.CarsList
import com.example.autoscout24.home.composeComponents.FailureView
import com.example.autoscout24.home.composeComponents.LoadingView
import com.example.autoscout24.ui.theme.AutoScout24Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.getAllCars()
        setContent {
            AutoScout24Theme {
                // A surface container using the 'background' color from the theme
                val uiState: HomeUiState by homeViewModel.homeUiState
                when (uiState) {
                    is HomeUiState.Failure -> {
                        FailureView(
                            stringResource(id = (uiState as HomeUiState.Failure).messageId),
                            retryCallback = ::retry
                        )
                    }

                    HomeUiState.Loading -> {
                        LoadingView()
                    }

                    HomeUiState.NoCarsFound -> {
                        FailureView(
                            stringResource(id = R.string.no_cars_found),
                            retryCallback = ::retry
                        )

                    }

                    is HomeUiState.Success -> {
                        CarsList(
                            cars = (uiState as HomeUiState.Success).cars,
                            onCallItemClicked = ::callOwner
                        )
                    }
                }
            }
        }

    }

    private fun retry() {
        homeViewModel.getAllCars()
    }


    private fun callOwner(phoneNumber: String) {
        val dialIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(dialIntent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AutoScout24Theme {
        Greeting("Android")
    }
}