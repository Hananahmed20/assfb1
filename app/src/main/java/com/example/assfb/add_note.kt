package com.example.assfb

 import android.content.ContentValues.TAG
 import android.content.Intent
 import android.os.Bundle
 import android.util.Log
 import android.widget.Button
 import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
 import com.google.firebase.firestore.FirebaseFirestore


class add_note : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    lateinit var titel :EditText
    lateinit var desc :EditText
    lateinit var num :EditText
    lateinit var btn_add :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)

          titel = findViewById<EditText>(R.id.ed_add_titel)
          desc = findViewById<EditText>(R.id.ed_desc)
          num = findViewById<EditText>(R.id.ed_numb)
          btn_add = findViewById<Button>(R.id.btn_add)


        btn_add.setOnClickListener {
            add_note(
                titel.text.toString(),
                desc.text.toString(),
                num.text.toString(),
            )
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }
    private fun add_note(titel:String,desc:String,num:String) {

        val note = hashMapOf(
            "titel" to titel ,
            "desc" to desc,
            "num" to num,
        )
        db.collection("notes")
            .add(note)
             .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

    }
}