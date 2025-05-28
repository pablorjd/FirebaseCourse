package dev.pablorjd.coursefirebase1.data

import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import kotlin.random.Random

class FirebaseInstance(context: Context) {

    private val db = Firebase.database

    init {
        FirebaseApp.initializeApp(context)
    }

    fun writeOfFirebase(){
        val myRef = db.reference
        val randomValue: String = Random.nextInt(1,200).toString()
        myRef.setValue("Mi primera escritura: $randomValue ")
    }

    fun setUpDataBaseListener(postLitener: ValueEventListener) {
        db.reference.addValueEventListener(postLitener)
    }
}