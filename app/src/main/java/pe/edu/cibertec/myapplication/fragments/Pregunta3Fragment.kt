package pe.edu.cibertec.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.myapplication.Adapter.FrutaAdapter
import pe.edu.cibertec.myapplication.Model.Fruta
import pe.edu.cibertec.myapplication.databinding.FragmentPregunta3Binding

class Pregunta3Fragment : Fragment() {
    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPregunta3Binding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val frutas = listOf(

            Fruta(
                "Manzana",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Apple_(1).jpg?width=300",
                "1:27 PM"
            ),

            Fruta(
                "Plátano",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Banana_(1).jpg?width=300",
                "2:00 PM"
            ),

            Fruta(
                "Fresa",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Strawberry_.jpg?width=300",
                "3:15 PM"
            ),

            Fruta(
                "Mango",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Mango_-_single.jpg?width=300",
                "4:30 PM"
            ),

            Fruta(
                "Papaya",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Papaya_fruit.JPG?width=300",
                "5:00 PM"
            ),

            Fruta(
                "Piña",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Pineapple_fruit.jpg?width=300",
                "6:20 PM"
            ),

            Fruta(
                "Naranja",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Orange_fruit.jpg?width=300",
                "7:10 PM"
            ),

            Fruta(
                "Mandarina",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Mandarin_fruit.jpg?width=300",
                "8:00 PM"
            ),

            Fruta(
                "Sandía",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Watermelon.jpg?width=300",
                "9:15 PM"
            ),

            Fruta(
                "Melón",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Melon_fruit.jpg?width=300",
                "10:00 AM"
            ),

            Fruta(
                "Uva",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Grape_fruit.jpg?width=300",
                "11:30 AM"
            ),

            Fruta(
                "Granadilla",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Granadilla.jpg?width=300",
                "12:00 PM"
            ),

            Fruta(
                "Maracuyá",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Passion_Fruit.jpg?width=300",
                "1:45 PM"
            ),

            Fruta(
                "Chirimoya",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Chirimoya_fruit.jpg?width=300",
                "2:30 PM"
            ),

            Fruta(
                "Tuna",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Prickly_pear_fruit_(30688397504).jpg?width=300",
                "3:00 PM"
            ),

            Fruta(
                "Durazno",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Peach.jpg?width=300",
                "4:15 PM"
            ),

            Fruta(
                "Pera",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Pear_fruit.jpg?width=300",
                "5:40 PM"
            ),

            Fruta(
                "Kiwi",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Kiwi_fruit.jpg?width=300",
                "6:50 PM"
            ),

            Fruta(
                "Coco",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Coconut_Fruit.jpg?width=300",
                "7:25 PM"
            ),

            Fruta(
                "Guayaba",
                urlimagen = "https://commons.wikimedia.org/wiki/Special:FilePath/Guava_.jpg?width=300",
                "8:10 PM"
            )
        )

    val adapter = FrutaAdapter(frutas)

    binding.rvFrutas.layoutManager = LinearLayoutManager(requireContext())
    binding.rvFrutas.adapter = adapter
}

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
    }
}
