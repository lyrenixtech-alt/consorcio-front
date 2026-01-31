package com.example.registrousuarioapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar
import android.app.DatePickerDialog

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val editBirthday = findViewById<TextInputEditText>(R.id.editBirthday)
        editBirthday.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Formato: dd/MM/yyyy
                    val formattedDate = String.format("%02d/%02d/%Y", selectedDay, selectedMonth + 1, selectedYear)
                    editBirthday.setText(formattedDate)
                },
                year,
                month,
                day
            )
            datePicker.show()
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