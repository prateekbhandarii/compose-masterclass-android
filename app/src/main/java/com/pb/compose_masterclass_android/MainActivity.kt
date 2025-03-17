package com.pb.compose_masterclass_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.ui.Modifier
import com.pb.compose_masterclass_android.compositionLocal.LocalSnackBarHostState
import com.pb.compose_masterclass_android.sideEffects.AutoScrollScreenRoot
import com.pb.compose_masterclass_android.ui.theme.ComposemasterclassandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposemasterclassandroidTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(
                            hostState = LocalSnackBarHostState.current
                        )
                    }
                ) { innerPadding ->
                    AutoScrollScreenRoot(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}