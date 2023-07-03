package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Ingreso")

        val username = findViewById<EditText>(R.id.etNombre)
        val password = findViewById<EditText>(R.id.etPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            ingreso(username,password)
        }
    }

    fun ingreso(username: EditText, password: EditText){
        val username = editTextToString(username)
        val password = editTextToString(password)

        var usuario = Usuario(username, password)
        usuario.nombre = "admin"
        usuario.clave = "2023"

        if(username.isEmpty()){
            Toast.makeText(this, "Ingrese un nombre de usuario", Toast.LENGTH_SHORT).show()
        }

        if(password.isEmpty()){
            Toast.makeText(this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show()
        }

        if(username==usuario.nombre && password==usuario.clave){
            Toast.makeText(this, "Ingreso exitoso", Toast.LENGTH_SHORT).show()
        }
        else{
            if(username!=usuario.nombre && username.isNotEmpty()){
                Toast.makeText(this, "No existe una cuenta con ese nombre", Toast.LENGTH_SHORT).show()
            }
            else if(password!=usuario.nombre && password.isNotEmpty()){
                Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun editTextToString(editText: EditText): String{
        return editText.text.toString()
    }
}

