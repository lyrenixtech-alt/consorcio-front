package com.devgroup.consorcioFront.models

data class Empresa(

    val nombre: String,
    val direccion: String,
    val cuit: String,
    val tipoCliente: String,
    val cantUF: Int,
    val cantPisos: Int,
    val cantTorres: Int,
    val tienePileta: Boolean,
    val anchoPileta: Double? = null,
    val largoPileta: Double? = null,
    val profundidadPileta: Double? = null,
    val litrosTotales: Int? = null,
    val tieneSum: Boolean,
    val m2Sum: Double? = null,
    val tieneGimnasio: Boolean,
    val m2Gimnasio: Double? = null,
    val capacidadGimnasio: Int? = null,
    val tieneSolarium: Boolean,
    val m2Solarium: Double? = null,
    val capacidadSolarium: Int? = null,
    val tieneParque: Boolean,
    val m2Parque: Double? = null,
    val tieneCochera: Boolean,
    val m2Cochera: Double? = null,
    val capacidadCochera: Int? = null,
    val tieneAscensores: Boolean,
    val cantAscensores: Int? = null,
    val capacidadAscensores: Double? = null,
    val empresaControladora: String? = null
)
