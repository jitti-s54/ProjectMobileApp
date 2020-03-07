package com.example.petlover

import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
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
        radioGroupGender.setOnCheckedChangeListener { group, chakedID ->
            val radioGender: RadioButton = findViewById(chakedID)
            Toast.makeText(this," On checked change : ${radioGender.text}",
                Toast.LENGTH_SHORT).show()
        }
    }
    private fun crateNewPet () {
        val name = findViewById<TextInputEditText>(R.id.name).text.toString()
        val pedigree = findViewById<TextInputEditText>(R.id.pedigree).text.toString()
        val birthday = findViewById<TextInputEditText>(R.id.birthday).text.toString()
        val genderId = radioGroupGender.checkedRadioButtonId
        val genderString = resources.getResourceEntryName(genderId)
        val generateId = db.collection("animals").document().id
        val user = FirebaseAuth.getInstance().currentUser?.uid
        val pet = hashMapOf(
            "name" to name,
            "pedigree" to pedigree,
            "birthday" to birthday,
            "gender" to genderString,
            "uid" to generateId,
            "uidUser" to user
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