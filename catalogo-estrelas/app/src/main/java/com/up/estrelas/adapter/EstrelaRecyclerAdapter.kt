package com.up.estrelas.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.up.estrelas.R
import com.up.estrelas.entity.Estrela
import kotlinx.android.synthetic.main.item_lista.view.*

class EstrelaRecyclerAdapter(private val estrelaList:
                             ArrayList<Estrela>) :
    RecyclerView.Adapter<EstrelaRecyclerAdapter.ViewHolder>() {

    // inflar o item da lista no recycler view
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    //retorna o tamanho da lista
    override fun getItemCount(): Int = estrelaList.count()

    // insere os elementos da lista no item da lista do recycler
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val estrela = estrelaList[position]
        holder.txt_descricao.text = estrela.descricao
        holder.txt_Tamanho.text = estrela.tamanho.toString()
    }

    // classe para mapear os componentes do item da lista
    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

        val txt_descricao: TextView = view.txtDescricao
        val txt_Tamanho: TextView = view.txtTamanho
    }

}