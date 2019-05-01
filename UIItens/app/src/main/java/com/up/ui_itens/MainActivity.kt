package com.up.ui_itens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // >>> ------------  Buttons ---------------
        // Verificando se o swit está ativo ou não ao clicar nele
        sLigado.setOnClickListener {
            if(sLigado.isChecked){
                Toast.makeText(
                    this,
                    "Ligado",
                    Toast.LENGTH_SHORT
                ).show()
                tbGenero.isChecked = true
            }
            else {
                Toast.makeText(
                    this,
                    "Desligado",
                    Toast.LENGTH_SHORT
                ).show()
                tbGenero.isChecked = false
            }
        }

        // trabalhando com o tonggle
        tbGenero.setOnClickListener {
            if(tbGenero.isChecked){
                Toast.makeText(
                    this,
                    "HOMEM",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                Toast.makeText(
                    this,
                    "MULHER",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // trabalhando com o checkbok
        cbButtons.setOnClickListener {
            verificaEntendimento()
        }

        cbWidgets.setOnClickListener {
            verificaEntendimento()
        }

        rbNaoEntendi.setOnClickListener {
            // mudar para sem check os meus checkboxs caso
            // clique no radio button não entendi
            cbButtons.isChecked = false
            cbWidgets.isChecked = false
        }

        // >>> ----------- Widgets -------------

        // ao alterar o seekbar o progress bar será alterado

        sbAlteraProgressBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {

                // quando alterar o valor do progresso
                override fun onProgressChanged(seekBar: SeekBar?,
                                               progress: Int,
                                               fromUser: Boolean) {

                    progressBar.progress = progress
                }

                // quando clicar no seekbar
                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                // quando parar de clicar no seekbar
                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            }
        )
        // ao alterar o seekbar o rating bar será alterado
        sbAlteraRatinbBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {

                // quando alterar o valor do seekbar
                override fun onProgressChanged(seekBar: SeekBar?,
                                               progress: Int,
                                               fromUser: Boolean) {

                    ratingBar.progress = progress
                }

                // quando clicar no seekbar
                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                // quando parar de clicar no seekbar
                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            }
        )

        imgPositivo.setOnClickListener {
            imgPositivo.setImageResource(R.drawable.ic_pizza)
        }

    }

    private fun verificaEntendimento(){
        // veificar se os checkbox não estão selecionados
        // caso não estejam o radio button será marcado como
        // não entendi, caso contrário, será marcado o entendi
        if (!cbButtons.isChecked && !cbWidgets.isChecked)
            rbNaoEntendi.isChecked = true
        else
            rbEntendi.isChecked = true
    }

}
