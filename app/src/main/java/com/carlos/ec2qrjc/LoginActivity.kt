package com.carlos.ec2qrjc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.carlos.ec2qrjc.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews(){
        binding.tilEmail.editText?.addTextChangedListener {text->
            binding.btnLogin.isEnabled = validateInputs(text.toString(),binding.tilPassword.editText?.text.toString())
        }
        binding.tilPassword.editText?.addTextChangedListener { text ->
            binding.btnLogin.isEnabled = validateInputs(binding.tilEmail.editText?.text.toString(),text.toString())
        }
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validateInputs(email: String,password: String):Boolean{
        val isEmailOk = email == "admin"
        val isPasswordOk = password == "123"
        return isEmailOk && isPasswordOk
    }
}