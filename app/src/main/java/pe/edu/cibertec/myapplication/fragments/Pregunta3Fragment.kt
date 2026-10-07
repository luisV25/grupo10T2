package pe.edu.cibertec.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.myapplication.adapter.FrutaAdapter
import pe.edu.cibertec.myapplication.databinding.FragmentPregunta3Binding
import pe.edu.cibertec.myapplication.model.Fruta

class Pregunta3Fragment : Fragment() {

    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val frutas = listOf(
            Fruta(
                "Manzana",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Apple_(1).jpg?width=300"
            ),
            Fruta(
                "Plátano",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Banana_(1).jpg?width=300"
            ),
            Fruta(
                "Fresa",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Strawberry_.jpg?width=300"
            ),
            Fruta(
                "Mango",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Mango_-_single.jpg?width=300"
            ),
            Fruta(
                "Papaya",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Papaya_fruit.JPG?width=300"
            ),
            Fruta(
                "Piña",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Pineapple_fruit.jpg?width=300"
            ),
            Fruta(
                "Naranja",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Orange_fruit.jpg?width=300"
            ),
            Fruta(
                "Mandarina",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Mandarin_fruit.jpg?width=300"
            ),
            Fruta(
                "Sandía",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Watermelon.jpg?width=300"
            ),
            Fruta(
                "Melón",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Melon_fruit.jpg?width=300"
            ),
            Fruta(
                "Uva",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Grape_fruit.jpg?width=300"
            ),
            Fruta(
                "Granadilla",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Granadilla.jpg?width=300"
            ),
            Fruta(
                "Maracuyá",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Passion_Fruit.jpg?width=300"
            ),
            Fruta(
                "Chirimoya",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Chirimoya_fruit.jpg?width=300"
            ),
            Fruta(
                "Tuna",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Prickly_pear_fruit_(30688397504).jpg?width=300"
            ),
            Fruta(
                "Durazno",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Peach.jpg?width=300"
            ),
            Fruta(
                "Pera",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Pear_fruit.jpg?width=300"
            ),
            Fruta(
                "Kiwi",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Kiwi_fruit.jpg?width=300"
            ),
            Fruta(
                "Coco",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Coconut_Fruit.jpg?width=300"
            ),
            Fruta(
                "Guayaba",
                "https://commons.wikimedia.org/wiki/Special:FilePath/Guava_.jpg?width=300"
            )
        )

        binding.rvFrutas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFrutas.adapter = FrutaAdapter(frutas)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}