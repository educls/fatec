// Troque o nome do pacote para o do seu projeto, se necessário
package com.example.login

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(
    
    val context: Context,

    val dados: MutableList<ItemModel> = mutableListOf(
        ItemModel(0, " ", 0, 0.0f)
    )
    
    ) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    var onItemClick: ((ItemModel) -> Unit)? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val textNome: TextView = view.findViewById(R.id.textNome)
        val textQuantidade: TextView = view.findViewById(R.id.textQuantidade)
        val textPreco: TextView = view.findViewById(R.id.textPreco)
        val buttonExcluir: Button = view.findViewById(R.id.buttonExcluir)


        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(dados[adapterPosition])
            }
        }
        init {
            buttonExcluir.setOnClickListener(){
                onItemClick?.invoke(dados[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_linha_recycler_view, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.buttonExcluir.setOnClickListener(){
            excluirItem(position)
        }

        val item = dados.get(position)
        holder.textNome.text = item.nome
        holder.textQuantidade.text = "Quantidade: " + item.qtde
        holder.textPreco.text = "Preço: " + item.preco
    }

    override fun getItemCount(): Int {
        return dados.size
    }

    fun excluirItem(position: Int) {
        dados.removeAt(position)
        notifyItemRemoved(position)

        (context as listacomprasActivity).atualizarValorTotal()
        return
    }


}