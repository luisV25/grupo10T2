package pe.edu.cibertec.myapplication.model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("recipes")
    val recipes: List<Recipe>,

    @SerializedName("total")
    val total: Int,

    @SerializedName("skip")
    val skip: Int,

    @SerializedName("limit")
    val limit: Int
)
