package edu.miu.homework4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var userList=ArrayList<User>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userList.add(User("John","Smith","jsmith@email.com","1234"))
        userList.add(User("Robert","Ellis","rellis@email.com","1234"))
        userList.add(User("Denny","Gullick","dgullick@email.com","1234"))
        userList.add(User("Martin","Fowler","mfowler@email.com","1234"))
        userList.add(User("Robert","Martin","rmartin@email.com","1234"))
    }

    fun signingIn(view: View) {
        var found:Boolean=false;
        for(user in userList){
            if(user.username == userName.text.toString() && user.password == passWord.text.toString())
                found=true;
        }
        if(found)
            println("successfully signed in")
    }
}
