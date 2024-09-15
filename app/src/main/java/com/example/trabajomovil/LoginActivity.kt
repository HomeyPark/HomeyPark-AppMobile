package com.example.trabajomovil

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addGoToSignUpHandler()
        addGoToHomeHandler()

    }

    private fun addGoToSignUpHandler() {
        val signUpBtn = findViewById<MaterialButton>(R.id.loginMain_goToSignUp)

        signUpBtn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun addGoToHomeHandler() {
        val homeBtn = findViewById<MaterialButton>(R.id.loginMain_goToHome)

        homeBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}