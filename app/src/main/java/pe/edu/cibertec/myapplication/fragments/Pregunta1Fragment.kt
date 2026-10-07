package pe.edu.cibertec.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.cibertec.myapplication.R
import pe.edu.cibertec.myapplication.databinding.FragmentPregunta1Binding
import java.util.Locale

class Pregunta1Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcular.setOnClickListener(this)
        binding.btnLimpiar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular -> calcularPenalidad()
            R.id.btnLimpiar -> limpiarCampos()
        }
    }

    private fun calcularPenalidad() {
        val input = binding.etDiasRetraso.text?.toString()?.trim()

        if (input.isNullOrEmpty()) {
            Toast.makeText(
                requireContext(),
                "Por favor, ingrese los días de retraso",
                Toast.LENGTH_SHORT
            ).show()

            binding.tilDiasRetraso.error = "Campo requerido"
            return
        }

        binding.tilDiasRetraso.error = null

        val dias = input.toIntOrNull()

        if (dias == null || dias < 0) {
            Toast.makeText(
                requireContext(),
                "Ingrese un número válido de días",
                Toast.LENGTH_SHORT
            ).show()

            binding.tilDiasRetraso.error =
                "Ingrese un número entero no negativo"
            return
        }

        if (dias <= 5) {

            binding.cardResultado.visibility = View.VISIBLE
            binding.tvMensajeTolerancia.visibility = View.VISIBLE

            binding.tvMensajeTolerancia.text =
                "Entrega dentro de la tolerancia contractual."

            binding.tvDiasRetrasoResult.text =
                "Días de retraso: $dias"

            binding.tvDiasComputables.text =
                "Días computables para penalidad (días - 5): 0"

            binding.tvPenalidadResultante.text =
                "Descuento o penalidad resultante: S/ 0.00"

        } else {

            val diasComputables = dias - 5
            val deduccion = 500.0 + (diasComputables * 150.0)

            val montoFormateado =
                String.format(Locale.US, "S/ %.2f", deduccion)

            binding.cardResultado.visibility = View.VISIBLE
            binding.tvMensajeTolerancia.visibility = View.GONE

            binding.tvDiasRetrasoResult.text =
                "Días de retraso: $dias"

            binding.tvDiasComputables.text =
                "Días computables para penalidad (días - 5): $diasComputables"

            binding.tvPenalidadResultante.text =
                "Descuento o penalidad resultante: $montoFormateado"
        }
    }

    private fun limpiarCampos() {
        binding.etDiasRetraso.setText("")
        binding.tilDiasRetraso.error = null
        binding.cardResultado.visibility = View.GONE
        binding.etDiasRetraso.requestFocus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}