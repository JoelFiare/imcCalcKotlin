package com.example.a123.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.a123.R

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result: Double = intent.extras?.getDouble("IMC_RESULT") ?: -1.0

        initComponent()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()

        when (result) {
            in 0.00..18.50 -> { //bajo peso
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)

            }

            in 18.51..24.99 -> { //peso normal
                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal)
            }

            in 25.00..29.99 -> { //sobre peso
                tvResult.text = getString(R.string.title_sobre_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDescription.text = getString(R.string.description_sobre_peso)
            }

            in 30.00..99.99 -> { //obesidad
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescription.text = getString(R.string.description_obesidad)
            }

            else -> { //error
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescription.text = getString(R.string.error)
            }


        }
    }

    private fun initComponent() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}