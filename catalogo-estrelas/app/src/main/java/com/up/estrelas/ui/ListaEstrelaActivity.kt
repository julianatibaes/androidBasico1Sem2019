package com.up.estrelas.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.up.estrelas.R
import com.up.estrelas.adapter.EstrelaRecyclerAdapter
import com.up.estrelas.entity.Estrela

class ListaEstrelaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_estrela)
        val recyclerView_= findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView_.setHasFixedSize(true)

        // responsável por medir e posicionar as visualizações dos itens
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        recyclerView_.layoutManager = layoutManager

        val adapter = EstrelaRecyclerAdapter(lista())
        recyclerView_.adapter = adapter
    }

    private fun lista(): ArrayList<Estrela>{
        return arrayListOf(
            Estrela(descricao = "sol", tamanho = 23F),
            Estrela(tamanho = 23F, descricao = "Gamma"),
            Estrela(descricao = "Sirus", tamanho = 3423F)
        )
    }
}
