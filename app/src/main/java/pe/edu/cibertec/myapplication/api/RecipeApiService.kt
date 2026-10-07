package pe.edu.cibertec.myapplication.api

import pe.edu.cibertec.myapplication.model.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET

interface RecipeApiService {

    @GET("recipes")
    fun getRecipes(): Call<RecipeResponse>
}