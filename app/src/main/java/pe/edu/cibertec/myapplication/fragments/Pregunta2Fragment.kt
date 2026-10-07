package pe.edu.cibertec.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.cibertec.myapplication.R
import pe.edu.cibertec.myapplication.databinding.FragmentPregunta2Binding
import java.util.Locale

/**
 * Mermas en lote de confección textil.
 * - prendas <= 10  -> sin descuento
 * - prendas  > 10  -> S/ 100.00 + S/ 28.00 por cada prenda sobre 10
 */
class Pregunta2Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta2Binding? = null
    private val binding get() = _binding!!

    companion object {
        private const val LIMITE_PRENDAS = 10
        private const val CARGO_BASE = 100.00
        private const val CARGO_POR_PRENDA = 28.00
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // El evento click se inicializa aquí (equivalente a onCreate en un Activity)
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular -> calcularMerma()
        }
    }

    private fun calcularMerma() {
        val prendas = binding.etPrendas.text.toString().trim().toIntOrNull()

        if (prendas == null || prendas < 0) {
            binding.tvResultado.text = ""
            Toast.makeText(requireContext(), R.string.merma_error_vacio, Toast.LENGTH_SHORT).show()
            return
        }

        if (prendas <= LIMITE_PRENDAS) {
            binding.tvResultado.text = getString(R.string.merma_dentro_margen)
        } else {
            val exceso = prendas - LIMITE_PRENDAS
            val total = CARGO_BASE + CARGO_POR_PRENDA * exceso
            binding.tvResultado.text = buildString {
                appendLine(getString(R.string.merma_fallas, prendas))
                appendLine(getString(R.string.merma_exceso, exceso))
                append(getString(R.string.merma_total, formatoMoneda(total)))
            }
        }
    }

    private fun formatoMoneda(monto: Double): String =
        String.format(Locale.US, "S/ %.2f", monto)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
