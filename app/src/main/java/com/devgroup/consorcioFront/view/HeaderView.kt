package com.devgroup.consorcioFront.imCorporal.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class HeaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.textViewStyle
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        // Aquí puedes aplicar un estilo por defecto si lo deseas.
        // Por ejemplo, para poner el texto en negrita y de un color determinado:
        // import android.graphics.Typeface
        // import androidx.core.content.ContextCompat
        // import com.devgroup.practicasejemplo.R
        //
        // setTypeface(null, Typeface.BOLD)
        // setTextColor(ContextCompat.getColor(context, R.color.white))
    }
}
