package pe.edu.cibertec.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.myapplication.adapter.RecipeAdapter
import pe.edu.cibertec.myapplication.api.RetrofitClient
import pe.edu.cibertec.myapplication.databinding.FragmentPregunta4Binding
import pe.edu.cibertec.myapplication.model.RecipeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta4Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        initListeners()
        cargarRecetas()
    }

    private fun setupRecyclerView() {
        adapter = RecipeAdapter()
        binding.rvRecipes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRecipes.adapter = adapter
    }

    private fun initListeners() {
        binding.btnCargar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if ((v?.id == binding.btnCargar.id) || (v == binding.btnCargar)) {
            Toast.makeText(requireContext(), "Cargando recetas...", Toast.LENGTH_SHORT).show()
            cargarRecetas()
        }
    }

    private fun cargarRecetas() {
        binding.progressBar.visibility = View.VISIBLE

        RetrofitClient.apiService.getRecipes().enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(
                call: Call<RecipeResponse>,
                response: Response<RecipeResponse>
            ) {
                if (_binding == null) return
                binding.progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val recipes = response.body()?.recipes ?: emptyList()
                    adapter.updateList(recipes)
                    if (recipes.isNotEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Se cargaron ${recipes.size} recetas",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "No se encontraron recetas",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Error en la respuesta del servidor: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                if (_binding == null) return
                binding.progressBar.visibility = View.GONE
                Toast.makeText(
                    requireContext(),
                    "Error de conexión: ${t.localizedMessage}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
