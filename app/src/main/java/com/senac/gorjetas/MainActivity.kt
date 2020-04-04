package com.senac.gorjetas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var percentualGorjetaSeekBar: SeekBar
    private lateinit var percentualGorjeta: TextView
    private lateinit var campoValor: EditText
    private lateinit var valorGorjeta15: EditText
    private lateinit var valorGorjeta: EditText
    private lateinit var valorTotal15: EditText
    private lateinit var valorTotal: EditText

    private fun FormatarValor(valor: Double): String {
        return String.format("%.2f", valor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        percentualGorjetaSeekBar = findViewById<SeekBar>(R.id.seekBar1)
        percentualGorjeta = findViewById<TextView>(R.id.TextView_Gorjeta)

        campoValor = findViewById<EditText>(R.id.EditText_valor)
        valorGorjeta15 = findViewById<EditText>(R.id.EditText_gorjeta15)
        valorGorjeta = findViewById<EditText>(R.id.EditText_gorjetaCustom)
        valorTotal15 = findViewById<EditText>(R.id.EditText_Total15)
        valorTotal = findViewById<EditText>(R.id.EditText_TotalCustom)

        percentualGorjetaSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                percentualGorjeta.text = i.toString()+" %";
                calculaValores()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        campoValor.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                calculaValores()
            }
        })
    }

    private fun calculaValores() {
        var valor: Double = 0.0;
        if (!campoValor.text.toString().isEmpty()) {
            valor = campoValor.text.toString().toDouble()
        }
        val gorjeta = CalculaGorjetas(valor, percentualGorjetaSeekBar.getProgress().toDouble())

        valorGorjeta15.setText(FormatarValor(gorjeta.getValorGorjeta15()))
        valorGorjeta.setText(FormatarValor(gorjeta.getValorGorjeta()))

        valorTotal15.setText(FormatarValor(gorjeta.getTotalComGorjeta15()))
        valorTotal.setText(FormatarValor(gorjeta.getTotalComGorjeta()))
    }
}
