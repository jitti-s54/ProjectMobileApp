package com.example.petlover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.signup_btn

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        signup_btn.setOnClickListener {
            registerfun()
            //val intent = Intent(this, Bottomnavigation::class.java)
            //startActivity(intent)

        }

    }

    private fun registerfun(){
        val username = findViewById<TextInputEditText>(R.id.inputEmailreg).text.toString()
        val pass = findViewById<TextInputEditText>(R.id.inputPassreg).text.toString()
        val confirmpass = findViewById<TextInputEditText>(R.id.cPassreg).text.toString()
        val showrong =  findViewById<TextView>(R.id.showwrog)

        Log.d("RegisterActivity", username)
        Log.d("RegisterActivity",pass)
        Log.d("RegisterActivity",confirmpass)
        val checkmail: Boolean = isEmailValid(username)
        if (checkmail && confirmpass == pass && pass.length <= 6){
            showrong.visibility = View.GONE
            val db = FirebaseFirestore.getInstance()
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(username,pass)
                .addOnCompleteListener{
                    if(!it.isSuccessful) return@addOnCompleteListener
                    var uid = it.result?.user?.uid
                    Log.d("RegisterActivity","Successfully ${uid}")
                    val user = hashMapOf(
                        "email" to username,
                        "uid" to uid
                    )
                    if (uid != null) {
                        db.collection("users").document(uid).set(user)
                            .addOnSuccessListener { Log.d("RegisterActivity", "DocumentSnapshot successfully written!") }
                            .addOnFailureListener { e -> Log.w("RegisterActivity", "Error writing document", e) }
                    }
                }

        }
        else{
            var somwrong: String= ""
            if (pass.length != 6){
                somwrong += "Your password need least than 6 character\n"
            }
            if (confirmpass != pass){
                somwrong += "Your password and confirmation password do not match.\n"
            }
            if (!checkmail){
                somwrong += "Bad format E-mail\n"
            }
            if (username.isEmpty()){
                somwrong += "Enter Your E-mail\n"
            }
            if (pass.isEmpty()){
                somwrong += "Enter Your Password\n"
            }
            showrong.text = somwrong
            showrong.visibility = View.VISIBLE
        }

    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
