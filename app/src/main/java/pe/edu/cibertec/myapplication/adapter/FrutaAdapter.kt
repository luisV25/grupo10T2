package pe.edu.cibertec.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.myapplication.databinding.ItemFrutaBinding
import pe.edu.cibertec.myapplication.model.Fruta

class FrutaAdapter(
    private val listaFrutas: List<Fruta>
) : RecyclerView.Adapter<FrutaAdapter.FrutaViewHolder>() {

    class FrutaViewHolder(
        val binding: ItemFrutaBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrutaViewHolder {

        val binding = ItemFrutaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FrutaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: FrutaViewHolder,
        position: Int
    ) {
        val fruta = listaFrutas[position]

        holder.binding.tvNombre.text = fruta.nombre

        Glide.with(holder.itemView.context)
            .load(fruta.urlImagen)
            .into(holder.binding.ivFoto)
    }

    override fun getItemCount(): Int = listaFrutas.size
}