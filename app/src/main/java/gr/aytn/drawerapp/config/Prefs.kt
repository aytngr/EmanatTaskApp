package gr.aytn.drawerapp.config

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context){


    private var TOKEN = "TOKEN"
    private var NAME = "NAME"
    private var SURNAME = "SURNAME"
    private var EMAIL = "EMAIL"
    private val preferences: SharedPreferences = context.getSharedPreferences("SharedPref",Context.MODE_PRIVATE)


    var token: String
        get() = preferences.getString(TOKEN,"").toString()
        set(value) = preferences.edit().putString(TOKEN, value).apply()
//    fun getToken2(){
//        preferences.getString(TOKEN,"").toString()
//    }
//    fun setToken2(value2:String){
//        preferences.edit().putString(TOKEN, value2).apply()
//    }
    var name: String
        get() = preferences.getString(NAME,"").toString()
        set(value) = preferences.edit().putString(NAME, value).apply()
    var surname: String
        get() = preferences.getString(SURNAME,"").toString()
        set(value) = preferences.edit().putString(SURNAME, value).apply()
    var email: String
        get() = preferences.getString(EMAIL,"").toString()
        set(value) = preferences.edit().putString(EMAIL, value).apply()
}




