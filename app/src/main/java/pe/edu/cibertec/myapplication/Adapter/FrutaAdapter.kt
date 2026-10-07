package pe.edu.cibertec.myapplication.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.myapplication.Model.Fruta
import pe.edu.cibertec.myapplication.databinding.ItemFrutaBinding

class FrutaAdapter(private var listafrutas: List<Fruta>): RecyclerView.Adapter<FrutaAdapter.ViewHolder>(){

    inner class ViewHolder( val binding: ItemFrutaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrutaAdapter.ViewHolder {
        val binding = ItemFrutaBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FrutaAdapter.ViewHolder, position: Int) {
       with(holder){
           with(listafrutas[position]){
               binding.tvnombre.text =nombre
               binding.tvhora.text = hora
               Glide.with(itemView.context)
                   .load(urlimagen)
                   .into(binding.ivfoto)
           }
       }
    }

    override fun getItemCount() = listafrutas.size

}
