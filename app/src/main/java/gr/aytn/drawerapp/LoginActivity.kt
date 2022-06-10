package gr.aytn.drawerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import gr.aytn.drawerapp.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val correctEmail = Constants.EMAIL
        val correctPassword = Constants.PASSWORD

        val etEmail: EditText = findViewById(R.id.email)
        val etPassword: EditText = findViewById(R.id.password)
        val tvMessage: TextView = findViewById(R.id.message)
        val btnLogin : Button = findViewById(R.id.login)



        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if(email == correctEmail && password == correctPassword){
                /*
                tvMessage.text = "Siz uğurla daxil oldunuz!"
                tvMessage.background = ContextCompat.getDrawable(this,R.drawable.correct_credentials_message
                 */
                startActivity(Intent(this, Main2Activity::class.java))
                finish()
            }else{
                if(email != correctEmail) {
                    etEmail.error = "Email yanlışdır!"
                }
                if(password != correctPassword){
                    etPassword.error = "Şifrə yanlışdır!"
                }
                tvMessage.text = "Email və ya şifrə yanlışdır!"
                tvMessage.background = ContextCompat.getDrawable(this,
                    R.drawable.wrong_credentials_message
                )
            }
        }
    }
}