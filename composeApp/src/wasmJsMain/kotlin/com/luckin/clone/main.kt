package com.luckin.clone

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.initialize
import kotlinx.browser.document

import com.luckin.clone.data.repository.FirebaseProductRepository

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val options = FirebaseOptions(
        apiKey = "AIzaSyCHZ21mQQGBlqB0bh2vJJSQ6d4Mzcx3d4g",
        projectId = "luckin-coffee-clone-vnt87",
        applicationId = "1:43929034212:web:ff51535f1f8ac29c6f7bf1",
        storageBucket = "luckin-coffee-clone-vnt87.firebasestorage.app",
        authDomain = "luckin-coffee-clone-vnt87.firebaseapp.com"
    )
    Firebase.initialize(options)

    val repository = FirebaseProductRepository(Firebase.firestore)

    ComposeViewport(document.body!!) {
        App(repository)
    }
}
