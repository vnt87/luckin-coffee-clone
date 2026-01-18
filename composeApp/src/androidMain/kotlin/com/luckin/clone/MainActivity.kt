package com.luckin.clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.luckin.clone.data.repository.FirebaseProductRepository
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = FirebaseProductRepository(Firebase.firestore)

        setContent {
            App(repository)
        }
    }
}
