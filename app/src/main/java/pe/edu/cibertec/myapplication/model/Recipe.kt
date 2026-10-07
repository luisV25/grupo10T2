package pe.edu.cibertec.myapplication.model

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("prepTimeMinutes")
    val prepTimeMinutes: Int,

    @SerializedName("difficulty")
    val difficulty: String,

    @SerializedName("cuisine")
    val cuisine: String
)
