package com.devgroup.consorcioFront

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devgroup.consorcioFront.primeraapp.pruebaActivity
import com.devgroup.consorcioFront.R


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnAltaCliente= findViewById<AppCompatButton>(R.id.btnAltaCliente)

        btnAltaCliente.setOnClickListener { navigateToAltaCliente() }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToAltaCliente(){
        val intent= Intent(this, pruebaActivity::class.java)
        startActivity(intent)
    }


}
