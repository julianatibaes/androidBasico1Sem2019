package com.up.calculotrabalhista

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_fac.*

class FACActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fac)

        //tornar o botão de voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // construindo um array com todos os itens da lista para aparecer no spinner
        // futuramente isso poderá ser uma lista recebida do banco de dados
        val fac = arrayOf(
            "Selecione uma opção",
            "Como saber quanto tenho de FGTS?",
            "Quantos por cento rede  o FGTS por mês?",
            "Quando é possível sacar o FGTS?"
        )

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_dropdown_item_1line,
            fac)

        // adicionar o modelo spinner com a lista de valores para o spinner
        sSelecaoFac.adapter = adapter


        sSelecaoFac.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {
                imgSac.visibility = View.VISIBLE
                txtExplicacao.text = ""
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                // pegar o valor de texto do item selecionado no spinner
                val selectedItem = parent!!.getItemAtPosition(position).toString()

                // para cada posição, iremos adicionar uma explicação
                when(position){
                    0 -> {
                        txtExplicacao.text = ""
                        imgSac.visibility = View.VISIBLE
                    }
                    1 -> {
                        txtExplicacao.text = (selectedItem + "\n" +
                                "1.  Acesse www.caixa.gov.br/extrato-fgts.\n" +
                                "2. Informe o número do seu NIS e clique em “cadastrar senha”.\n" +
                                "3. Leia o regulamento e clique em “aceito”.\n" +
                                "4. Preencha todos os campos com os seus dados pessoais. Aqui, " +
                                "você vai precisar do número do seu Titulo de Eleitor.\n" +
                                "5. Crie uma senha com até 8 dígitos e confirme.\n" +
                                "6. Você receberá uma notificação de cadastro realizado.\n" +
                                "7. Para acessar, preencha os campos e aperte em OK.\n" +
                                "8. Pronto. Você já pode consultar o seu extrato do FGTS. \n")
                        // torna a imagem invisível e sem ocupar espaço na tela
                        imgSac.visibility = View.GONE
                    }
                    2 -> {
                        txtExplicacao.text = (selectedItem + "\n" +
                                "Mais ou menos 3%")
                        imgSac.visibility = View.VISIBLE
                    }
                    3 -> {
                        txtExplicacao.text = (selectedItem +
                                "\n 1. Demissão sem justa causa" +
                                "\n 2. Término do contrato por prazo determinado" +
                                "\n 3. Rescisão do contrato por extinção da empresa, supressão de parte de suas atividades, fechamento de estabelecimentos, falecimento do empregador individual ou decretação de nulidade do contrato de trabalho" +
                                "\n 4. Rescisão do contrato por culpa recíproca ou força maior" +
                                "\n 5. Aposentadoria" +
                                "\n 6. Necessidade pessoal, urgente e grave, decorrente de desastre natural" +
                                " causado por chuvas ou inundações que tenham atingido a área de residência " +
                                "do trabalhador, quando a situação " +
                                "de emergência ou o estado de calamidade pública for assim reconhecido, por" +
                                " meio de portaria do Governo Federal" +
                                "\n7. Suspensão do Trabalho Avulso"
                        )
                        imgSac.visibility = View.GONE
                    }
                }
            }

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
