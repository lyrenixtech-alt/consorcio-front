package com.devgroup.consorcioFront

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.SwitchCompat
import com.devgroup.consorcioFront.models.Empresa
import com.devgroup.consorcioFront.R




class AltaClienteFragment : Fragment(R.layout.fragment_alta_cliente) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val switchPileta = view.findViewById<SwitchCompat>(R.id.switchPileta)
        val containerCamposPileta = view.findViewById<View>(R.id.containerCamposPileta)
        val switchSum = view.findViewById<SwitchCompat>(R.id.switchSum)
        val containerCamposSum = view.findViewById<View>(R.id.containerCamposSum)
        val switchGimnasio = view.findViewById<SwitchCompat>(R.id.switchGimnasio)
        val containerCamposGimnasio = view.findViewById<View>(R.id.containerCamposGimnasio)
        val switchSolarium = view.findViewById<SwitchCompat>(R.id.switchSolarium)
        val containerCamposSolarium = view.findViewById<View>(R.id.containerCamposSolarium)
        val switchParque = view.findViewById<SwitchCompat>(R.id.switchParque)
        val containerCamposParque = view.findViewById<View>(R.id.containerCamposParque)
        val switchCochera = view.findViewById<SwitchCompat>(R.id.switchCochera)
        val containerCamposCochera = view.findViewById<View>(R.id.containerCamposCochera)
        val switchAscensores = view.findViewById<SwitchCompat>(R.id.switchAscensores)
        val containerCamposAscensores = view.findViewById<View>(R.id.containerCamposAscensores)




        switchPileta.setOnCheckedChangeListener { _, isChecked ->
            containerCamposPileta.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        switchSum.setOnCheckedChangeListener { _, isChecked ->
            containerCamposSum.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        switchGimnasio.setOnCheckedChangeListener { _, isChecked ->
            containerCamposGimnasio.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        switchSolarium.setOnCheckedChangeListener { _, isChecked ->
            containerCamposSolarium.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        switchParque.setOnCheckedChangeListener { _, isChecked ->
            containerCamposParque.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        switchCochera.setOnCheckedChangeListener { _, isChecked ->
            containerCamposCochera.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        switchAscensores.setOnCheckedChangeListener { _, isChecked ->
            containerCamposAscensores.visibility = if (isChecked) View.VISIBLE else View.GONE
        }


    }
    fun limpiarCampos(){
        val vistaInterna = view ?: return
        val listaIds = listOf(
            R.id.etNombreEdificio,
            R.id.etDireccion,
            R.id.etCuit,
            R.id.etCantUF,
            R.id.etCantPisos,
            R.id.etCantTorres,
            R.id.etAncho,
            R.id.etLargo,
            R.id.etProfundidad,
            R.id.etLitros,
            R.id.etMedidasSum,
            R.id.etMedidasGimnasio,
            R.id.etCapacidadGimnasio,
            R.id.etMedidasSolarium,
            R.id.etCapacidadSolarium,
            R.id.etMedidasCochera,
            R.id.etCapacidadCochera,
            R.id.etCantidadAscensores,
            R.id.etCapacidadAscensores,
            R.id.etEmpresaControladora,
            R.id.etMedidasParque,
            R.id.etMedidasCochera
        )
        for (id in listaIds) {
            val campo = vistaInterna.findViewById<android.widget.EditText>(id)
            campo?.text?.clear()
            campo?.error = null
        }
        val switches = listOf(
            R.id.switchPileta, R.id.switchSum, R.id.switchGimnasio,
            R.id.switchSolarium, R.id.switchParque, R.id.switchCochera,
            R.id.switchAscensores
        )

        for (sId in switches) {
            vistaInterna.findViewById<androidx.appcompat.widget.SwitchCompat>(sId)?.isChecked = false
        }

        vistaInterna.findViewById<android.widget.EditText>(R.id.etNombreEdificio)?.requestFocus()

    }
    fun validarDatos(): Boolean {
        val vista = view ?: return false
        var esValido = true
        val etNombre = vista.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etNombreEdificio)
        val etCuit = vista.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etCuit)
        val etDireccion = vista.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etDireccion)
        val etCantUF = vista.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etCantUF)
        val etCantPisos = vista.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etCantPisos)
        val etCantTorres = vista.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etCantTorres)

        if (etNombre?.text.isNullOrBlank()) {
            etNombre?.error = "El nombre es obligatorio"
            esValido = false
        }

        if (etCuit?.text.isNullOrBlank()) {
            etCuit?.error = "El CUIT es obligatorio"
            esValido = false
        }
        if (etDireccion?.text.isNullOrBlank()) {
            etDireccion?.error = "La direccion es obligatoria"
            esValido = false
        }
        if (etCantUF?.text.isNullOrBlank()) {
            etCantUF?.error = "La cantidad de unidades es obligatoria"
            esValido = false
        }
        if (etCantPisos?.text.isNullOrBlank()) {
            etCantPisos?.error = "La cantidad de pisos es obligatoria"
            esValido = false
        }
        if (etCantTorres?.text.isNullOrBlank()) {
            etCantTorres?.error = "La cantidad de torres es obligatoria"
            esValido = false
        }


        return esValido
    }
    fun crearObjetoEmpresa(tipo: String): Empresa {
        val v = requireView()

        return Empresa(
            nombre = v.findViewById<android.widget.EditText>(R.id.etNombreEdificio).text.toString(),
            direccion = v.findViewById<android.widget.EditText>(R.id.etDireccion).text.toString(),
            cuit = v.findViewById<android.widget.EditText>(R.id.etCuit).text.toString(),
            tipoCliente = tipo,
            cantUF = v.findViewById<android.widget.EditText>(R.id.etCantUF).text.toString().toIntOrNull() ?: 0,
            cantPisos = v.findViewById<android.widget.EditText>(R.id.etCantPisos).text.toString().toIntOrNull() ?: 0,
            cantTorres = v.findViewById<android.widget.EditText>(R.id.etCantTorres).text.toString().toIntOrNull() ?: 0,
            tienePileta = v.findViewById<SwitchCompat>(R.id.switchPileta).isChecked,
            anchoPileta = v.findViewById<android.widget.EditText>(R.id.etAncho).text.toString().toDoubleOrNull(),
            largoPileta = v.findViewById<android.widget.EditText>(R.id.etLargo).text.toString().toDoubleOrNull(),
            profundidadPileta = v.findViewById<android.widget.EditText>(R.id.etProfundidad).text.toString().toDoubleOrNull(),
            litrosTotales = v.findViewById<android.widget.EditText>(R.id.etLitros).text.toString().toIntOrNull(),
            tieneSum = v.findViewById<SwitchCompat>(R.id.switchSum).isChecked,
            m2Sum = v.findViewById<android.widget.EditText>(R.id.etMedidasSum).text.toString().toDoubleOrNull(),
            tieneGimnasio = v.findViewById<SwitchCompat>(R.id.switchGimnasio).isChecked,
            m2Gimnasio = v.findViewById<android.widget.EditText>(R.id.etMedidasGimnasio).text.toString().toDoubleOrNull(),
            capacidadGimnasio = v.findViewById<android.widget.EditText>(R.id.etCapacidadGimnasio).text.toString().toIntOrNull(),
            tieneSolarium = v.findViewById<SwitchCompat>(R.id.switchSolarium).isChecked,
            m2Solarium = v.findViewById<android.widget.EditText>(R.id.etMedidasSolarium).text.toString().toDoubleOrNull(),
            capacidadSolarium = v.findViewById<android.widget.EditText>(R.id.etCapacidadSolarium).text.toString().toIntOrNull(),
            tieneParque = v.findViewById<SwitchCompat>(R.id.switchParque).isChecked,
            m2Parque = v.findViewById<android.widget.EditText>(R.id.etMedidasParque).text.toString().toDoubleOrNull(),
            tieneCochera = v.findViewById<SwitchCompat>(R.id.switchCochera).isChecked,
            m2Cochera = v.findViewById<android.widget.EditText>(R.id.etMedidasCochera).text.toString().toDoubleOrNull(),
            capacidadCochera = v.findViewById<android.widget.EditText>(R.id.etCapacidadCochera).text.toString().toIntOrNull(),
            tieneAscensores = v.findViewById<SwitchCompat>(R.id.switchAscensores).isChecked,
            cantAscensores = v.findViewById<android.widget.EditText>(R.id.etCantidadAscensores).text.toString().toIntOrNull(),
            capacidadAscensores = v.findViewById<android.widget.EditText>(R.id.etCapacidadAscensores).text.toString().toDoubleOrNull(),
            empresaControladora = v.findViewById<android.widget.EditText>(R.id.etEmpresaControladora).text.toString()

        )
    }



}


