package com.up.calculotrabalhista

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_fgts.*

class FGTSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fgts)

        //tornar o botão de voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // zerar valores variável
        txtZeraSalario.setOnClickListener {
            etcSalarioBruto.setText("")
        }

        // zerar valores variável
        txtZerarMeses.setOnClickListener {
            etxMesesTrabalhos.setText("")
        }

        // calcular o fgts
        btnCalcular.setOnClickListener {
            if (etcSalarioBruto.text.isNotEmpty() &&
                etxMesesTrabalhos.text.isNotEmpty()){
                val valorProporcional = etcSalarioBruto.text.toString().toDouble() * 0.8
                val meses = etxMesesTrabalhos.text.toString().toFloat()
                val fgts = (valorProporcional * meses)

                txtResultado.text = fgts.toString()
            }
        }

        // acessar uma página da internet
        btnFonte.setOnClickListener {
            val uri = Uri.parse("https://calculofgts.net/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    // define as ações dos botões do menu
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if(item?.itemId == android.R.id.home){
            // fecha a atividade
            finish()
            true
        } else super.onOptionsItemSelected(item)
    }
}
