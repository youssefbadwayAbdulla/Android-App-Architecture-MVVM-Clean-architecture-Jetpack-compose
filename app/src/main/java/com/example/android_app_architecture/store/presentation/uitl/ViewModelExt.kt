package com.example.android_app_architecture.store.presentation.uitl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_app_architecture.uitl.Event
import com.example.android_app_architecture.uitl.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sentEvent(event: Any){
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}