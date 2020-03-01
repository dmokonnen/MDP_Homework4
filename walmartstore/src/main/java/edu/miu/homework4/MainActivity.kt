package edu.miu.homework4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var userList=ArrayList<User>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userList.add(User("Demisew","Mokonnen","demisewt@gmail.com","1234"))
        userList.add(User("John","Smith","jsmith@email.com","1234"))
        userList.add(User("Robert","Ellis","rellis@email.com","1234"))
        userList.add(User("Denny","Gullick","dgullick@email.com","1234"))
        userList.add(User("Martin","Fowler","mfowler@email.com","1234"))
        userList.add(User("Robert","Martin","rmartin@email.com","1234"))
        val newUser = intent.getSerializableExtra("newUser") as? User
        if (newUser != null) {
            userList.add(newUser)
        }
    }

    fun signingIn(view: View) {
        var found:Boolean=false;
        val intent = Intent(this, ShopppingActivity::class.java)
        var input = userName.text.toString()

        for(user in userList){
            if(user.username == userName.text.toString() && user.password == passWord.text.toString())
                found=true;
        }
        if(found) {
            intent.putExtra("message",input )
            startActivity(intent)
        }
    }

    fun createAccount(view: View) {
        val intent=Intent(this,CreateAccountActivity::class.java)
        startActivity(intent)
    }
    private fun composeEmail(addresses: Array<String>, subject: String,message:String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
            //setType("message/rfc822")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    fun composeEmail(view: View) {
        val address=Array(1){userName.text.toString()}
        var found=false
        lateinit var pw: String
        for(user in userList){
            if(user.username == userName.text.toString()) {
                pw=user.password
                found=true
                break
            }

        }
        var message:String
        message = if (!found) {
            "You don't have account with this email."
        } else "your password is $pw without single quotes."
        composeEmail(address,"Your forgotten password",message)
    }
}
