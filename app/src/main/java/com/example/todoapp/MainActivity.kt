package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val validator = Validator()

        binding.button.setOnClickListener {

            binding.layoutEmail.error =
                validator.emailValid(binding.emailEditText.text)
            binding.layoutPassword.error =
                validator.passwordValid(binding.passwordEditText.text)

            if (binding.layoutEmail.error == null && binding.layoutPassword.error == null)
                toastShow(getString(R.string.success))
        }
        setContentView(binding.root)
    }
    fun toastShow(success: String) =
        Toast.makeText(applicationContext, success, Toast.LENGTH_SHORT).show()
}