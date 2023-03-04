package com.example.assfb

 import android.annotation.SuppressLint
 import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
  import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    private lateinit var recview: RecyclerView
    lateinit var add_Note: FloatingActionButton
    private lateinit var arrayNote :ArrayList<notemodel>


        @SuppressLint("SuspiciousIndentation")
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          val db = FirebaseFirestore.getInstance()
          recview = findViewById(R.id.recyclerView)
         add_Note  = findViewById(R.id.add)

         add_Note.setOnClickListener {
           val i = Intent(this, add_note::class.java)
             startActivity(i)
         }

          recview.layoutManager = LinearLayoutManager(this)
          recview.setHasFixedSize(true)
          arrayNote = arrayListOf()
          db.collection("notes").get().addOnSuccessListener {
              if (!it.isEmpty){
                  for (data in it.documents){
                      val not : notemodel? = data.toObject(notemodel::class.java)
                      if (not != null){
                          arrayNote.add(not)
                      }
                  }
                  recview.adapter = MyAdapter(arrayNote)
              }

          }
              .addOnFailureListener { exception ->
                  Log.w(ContentValues.TAG, "Error getting documents.", exception)
              }

    }

}