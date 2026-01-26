package com.example.registrousuarioapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        btnRegistrar.setOnClickListener {
            if (validarCampos()) {
                // Aquí podrías guardar los datos o enviarlos a una API
                Toast.makeText(this, "¡Usuario registrado con éxito!", Toast.LENGTH_LONG).show()
                // Ejemplo: finish() para volver a la pantalla anterior
            }
        }
    }

    private fun validarCampos(): Boolean {
        val editNombre = findViewById<TextInputEditText>(R.id.editNombre)
        val editApellido = findViewById<TextInputEditText>(R.id.editApellido)
        val editDni = findViewById<TextInputEditText>(R.id.editDni)
        val editTelefono = findViewById<TextInputEditText>(R.id.editTelefono)
        val editEmail = findViewById<TextInputEditText>(R.id.editEmail)

        val nombre = editNombre.text.toString().trim()
        val apellido = editApellido.text.toString().trim()
        val dni = editDni.text.toString().trim()
        val telefono = editTelefono.text.toString().trim()
        val email = editEmail.text.toString().trim()

        // Validar campos vacíos
        if (nombre.isEmpty()) {
            editNombre.error = "El nombre es obligatorio"
            editNombre.requestFocus()
            return false
        }
        if (apellido.isEmpty()) {
            editApellido.error = "El apellido es obligatorio"
            editApellido.requestFocus()
            return false
        }
        if (dni.isEmpty()) {
            editDni.error = "El DNI es obligatorio"
            editDni.requestFocus()
            return false
        }
        if (dni.length < 7 || dni.length > 8) {
            editDni.error = "El DNI debe tener 7 u 8 dígitos"
            editDni.requestFocus()
            return false
        }
        if (telefono.isEmpty()) {
            editTelefono.error = "El teléfono es obligatorio"
            editTelefono.requestFocus()
            return false
        }
        if (email.isEmpty()) {
            editEmail.error = "El correo es obligatorio"
            editEmail.requestFocus()
            return false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.error = "Correo inválido"
            editEmail.requestFocus()
            return false
        }

        return true
    }
}