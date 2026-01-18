package com.luckin.clone

import androidx.compose.ui.window.ComposeUIViewController
import com.luckin.clone.data.repository.FirebaseProductRepository
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

fun MainViewController() = ComposeUIViewController {
    val repository = FirebaseProductRepository(Firebase.firestore)
    App(repository)
}
