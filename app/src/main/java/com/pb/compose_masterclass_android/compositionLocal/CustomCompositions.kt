package com.pb.compose_masterclass_android.compositionLocal

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.compositionLocalOf

val LocalSnackBarHostState = compositionLocalOf {
    SnackbarHostState()
}