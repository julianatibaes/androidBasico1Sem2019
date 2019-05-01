package com.up.calculotrabalhista

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // abre a tela de FAC
        btnFAC.setOnClickListener {
            // cria a intent para preparar os dados que vao abrir a atividade
            val intent = Intent(this, FACActivity::class.java)
            startActivity(intent)
        }

        // abre a tela de FGTS
        btnFGTS.setOnClickListener {

            // cria a intent para preparar os dados que vao abrir a atividade
            val intent = Intent(this, FGTSActivity::class.java)
            startActivity(intent)
        }
    }
}
