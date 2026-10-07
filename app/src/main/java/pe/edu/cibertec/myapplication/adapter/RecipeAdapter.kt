package pe.edu.cibertec.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.cibertec.myapplication.R
import pe.edu.cibertec.myapplication.databinding.ItemRecipeBinding
import pe.edu.cibertec.myapplication.model.Recipe

class RecipeAdapter(
    private var recipeList: List<Recipe> = emptyList()
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        val context = holder.itemView.context
        with(holder.binding) {
            tvRecipeId.text = context.getString(R.string.recipe_id_format, recipe.id)
            tvRecipeName.text = recipe.name
            tvPrepTime.text = context.getString(R.string.recipe_prep_time_format, recipe.prepTimeMinutes)
            tvDifficulty.text = context.getString(R.string.recipe_difficulty_format, recipe.difficulty)
            tvCuisine.text = recipe.cuisine
        }
    }

    override fun getItemCount(): Int = recipeList.size

    fun updateList(newList: List<Recipe>) {
        recipeList = newList
        notifyDataSetChanged()
    }
}
