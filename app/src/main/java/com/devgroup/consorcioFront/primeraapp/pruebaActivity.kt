package com.devgroup.consorcioFront.primeraapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devgroup.consorcioFront.AltaClienteFragment
import com.devgroup.consorcioFront.R






class pruebaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prueba)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val clientes = arrayOf("EDIFICIO", "BARRIO CERRADO", "LOCALES EN GALERIA",)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, clientes)
        val autoCompleteClientes = findViewById<AutoCompleteTextView>(R.id.autoCompleteClientes)
        val btnCancelar =findViewById<com.google.android.material.button.MaterialButton>(R.id.btnCancelar)
        val btnGuardarEmpresa= findViewById<com.google.android.material.button.MaterialButton>(R.id.btnGuardar)

        autoCompleteClientes.setAdapter(adapter)


        autoCompleteClientes.setOnItemClickListener { parent, _, position, _ ->
            val clienteSeleccionado = parent.getItemAtPosition(position).toString()
            autoCompleteClientes.setText(clienteSeleccionado, false)
            autoCompleteClientes.dismissDropDown()
            autoCompleteClientes.clearFocus()
            val fragment = when (position) {
                0 -> AltaClienteFragment()
                1 -> AltaClienteFragment()
                2 -> AltaClienteFragment()
                else -> AltaClienteFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }
        btnCancelar.setOnClickListener {

            val fragmentActual = supportFragmentManager.findFragmentById(R.id.fragment_container)

            if (fragmentActual is AltaClienteFragment) {
                fragmentActual.limpiarCampos()
            }
        }
        btnGuardarEmpresa.setOnClickListener {
            val fragmentActual = supportFragmentManager.findFragmentById(R.id.fragment_container) as? AltaClienteFragment

            if (fragmentActual != null) {

                if (fragmentActual.validarDatos()) {


                    val tipoSeleccionado = autoCompleteClientes.text.toString()
                    val nuevaEmpresa = fragmentActual.crearObjetoEmpresa(tipoSeleccionado)

                    println("OBJETO CREADO EXITOSAMENTE: $nuevaEmpresa")
                    Toast.makeText(this, "Empresa ${nuevaEmpresa.nombre} guardada", Toast.LENGTH_LONG).show()
                    fragmentActual.limpiarCampos()
                } else {
                    Toast.makeText(this, "Por favor, corrige los errores de mas arriba", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
