package pe.edu.cibertec.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.myapplication.databinding.ActivityPregunta3Binding
import java.util.Locale

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
            Toast.makeText(this, "Por favor, ingrese los días de retraso", Toast.LENGTH_SHORT).show()
            binding.tilDiasRetraso.error = "Campo requerido"
            return
        }

        binding.tilDiasRetraso.error = null

        val dias = input.toIntOrNull()
        if (dias == null || dias < 0) {
            Toast.makeText(this, "Ingrese un número válido de días", Toast.LENGTH_SHORT).show()
            binding.tilDiasRetraso.error = "Ingrese un número entero no negativo"
            return
        }

        if (dias <= 5) {
            binding.cardResultado.visibility = View.VISIBLE
            binding.tvMensajeTolerancia.visibility = View.VISIBLE
            binding.tvMensajeTolerancia.text = "Entrega dentro de la tolerancia contractual."
            binding.tvDiasRetrasoResult.text = "Días de retraso: $dias"
            binding.tvDiasComputables.text = "Días computables para penalidad (días - 5): 0"
            binding.tvPenalidadResultante.text = "Descuento o penalidad resultante: S/ 0.00"
        } else {
            val diasComputables = dias - 5
            val deduccion = 500.0 + (diasComputables * 150.0)
            val montoFormateado = String.format(Locale.US, "S/ %.2f", deduccion)

            binding.cardResultado.visibility = View.VISIBLE
            binding.tvMensajeTolerancia.visibility = View.GONE
            binding.tvDiasRetrasoResult.text = "Días de retraso: $dias"
            binding.tvDiasComputables.text = "Días computables para penalidad (días - 5): $diasComputables"
            binding.tvPenalidadResultante.text = "Descuento o penalidad resultante: $montoFormateado"
        }
    }

    private fun limpiarCampos() {
        binding.etDiasRetraso.setText("")
        binding.tilDiasRetraso.error = null
        binding.cardResultado.visibility = View.GONE
        binding.etDiasRetraso.requestFocus()
    }
}
