package com.example.petlover

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_addpet.*
import java.util.*
import kotlin.collections.HashMap

class AddActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    data class Pet(
        var id: String ?= null,
        var name: String ?= null,
        var pedigree: String ?= null,
        var birthday: Date ?= null,
        var gender: String ?= null
//        var catagoly: Array<String>? = null
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addpet)
        buttonAdd.setOnClickListener {
            crateNewPet()
        }
    }
    private fun crateNewPet () {
        val name = findViewById<TextInputEditText>(R.id.name).text.toString()
        val pedigree = findViewById<TextInputEditText>(R.id.pedigree).text.toString()
//        val birthday = findViewById<TextInputEditText>(R.id.birthday).text.toString()
//        val gender = findViewById<TextInputEditText>(R.id.radioGroupGender).text.toString()
//        val catagoly = arrayOf("1", "2", "3")
        val generateId = db.collection("animals").document().id
        val pet = hashMapOf(
            "name" to name,
            "pedigree" to pedigree,
//            "birthday" to birthday,
//            "gender" to gender,
            "uid" to generateId
//            "catagoly" to catagoly

        )
        db.collection("animals").document(generateId).set(pet)
            .addOnSuccessListener {documentReference ->
                Log.d("Add pet done", "DocumentSnapshot added with ID: ${generateId}")
            }
            .addOnFailureListener { e ->
                Log.w("Add pet error", "Error adding document", e)
            }
    }
}