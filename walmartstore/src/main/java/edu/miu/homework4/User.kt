package edu.miu.homework4

import java.io.Serializable

class User(var firstname:String,var lastName:String, var username:String, var password:String):Serializable{
    //firstname, lastname,
    //username (will be an email id) and password instances
    override fun toString(): String{
        return "User(firstname='$firstname', lastName='$lastName', username='$username')"
    }
}