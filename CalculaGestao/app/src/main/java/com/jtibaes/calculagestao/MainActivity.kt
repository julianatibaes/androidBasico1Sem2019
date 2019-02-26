package com.jtibaes.calculagestao

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculo.setOnClickListener {
            if (etNumMesSem.text.toString().isNotEmpty()) {
                if(tbTipoMes.isChecked == true){
                    calculaMeses()
                } else{
                    calculaSemanas()
                }
            }else {
                val msg  = "Insira o número de semanas."
                txtResultado.text = msg
            }
        }
    }

    private fun calculaMeses(){
        if ((etNumMesSem.text.toString().toInt() > 0)
            && (etNumMesSem.text.toString().toInt() < 45)) {

            val valorMeses = (etNumMesSem.text.toString().toFloat() / 4.3482.toFloat()).toInt()
            val valorTotalMeses = etNumMesSem.text.toString().toFloat() / 4.3482.toFloat()
            val valorSemanas = ((valorTotalMeses - valorMeses)*4.3482.toFloat()).toInt()

            val result: String =  valorMeses.toString() +
                    " mese(s) e "+
                    valorSemanas.toString() +
                    " semana(s)"

            txtResultado.text = result
        } else {
            val msg  = "Insira um número de semanas válido."
            txtResultado.text = msg
        }
    }

    private fun calculaSemanas(){
        if ((etNumMesSem.text.toString().toInt() > 0)
            && (etNumMesSem.text.toString().toInt() <= 10)) {

            val valorSemanas = (etNumMesSem.text.toString().toFloat() * 4.3482.toFloat()).toInt()
            val result: String =  valorSemanas.toString() + " semana(s)"

            txtResultado.text = result
        } else {
            val msg  = "Insira um número de meses válido."
            txtResultado.text = msg
        }
    }
}
