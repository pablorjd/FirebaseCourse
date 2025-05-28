package dev.pablorjd.coursefirebase1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import dev.pablorjd.coursefirebase1.data.FirebaseInstance
import dev.pablorjd.coursefirebase1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var firebaseInstance: FirebaseInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseInstance = FirebaseInstance(this)

        setUI()
        setUpListeners()


    }

    private fun setUpListeners() {
        val postLitener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue<String>()

                if (data != null) binding.tvResultado.text = data
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("Error Logs", error.details)
            }
        }
        firebaseInstance.setUpDataBaseListener(postLitener)
    }

    private fun setUI() {
        binding.btnUpdate.setOnClickListener {
            firebaseInstance.writeOfFirebase()
        }
    }
}