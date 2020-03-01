package edu.miu.homework4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }
    fun accountCreating(view: View) {
        if((fname.text.isBlank() || lname.text.isBlank() || email.text.isBlank() || cpassword.text.isBlank()) ){
            Toast.makeText(this, "Blank field(s) is(are) not accepted", Toast.LENGTH_LONG).show()
        }
       else{
            val intent = Intent(this, MainActivity::class.java)
            var newUser=User(fname.text.toString(),lname.text.toString(),email.text.toString(),cpassword.text.toString())
            intent.putExtra("newUser",newUser)

            findViewById<Button>(R.id.cAccount).setOnClickListener{
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
            }
            startActivity(intent)
        }
    }
}
