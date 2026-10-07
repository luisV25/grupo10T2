package pe.edu.cibertec.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.myapplication.databinding.ActivityPregunta1Binding

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    private val listaUsuarios = listOf(
        Usuario("I202220383", "12345678"),
        Usuario("I202015857", "12345678"),
        Usuario("I201920650", "73419193"),
        Usuario("I202400593", "73527876"),
        Usuario("I202504498", "60070215"),
        Usuario("I201923072", "12345678"),
        Usuario("I202502383", "12345678")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.btnIngresar -> {

                val usuario = binding.edtUsuario.text.toString()
                val password = binding.edtPassword.text.toString()

                autenticarUsuario(usuario, password)
            }
        }
    }

    private fun autenticarUsuario(usuario: String, password: String) {

        if (usuario.isBlank() || password.isBlank()) {

            Toast.makeText(
                this,
                "Ingrese usuario y contraseña",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        if (validarCredenciales(usuario, password)) {

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            finish()

        } else {

            Toast.makeText(
                this,
                "Usuario o contraseña incorrectos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun validarCredenciales(
        usuario: String,
        password: String
    ): Boolean {

        return listaUsuarios.any {
            it.usuario == usuario && it.password == password
        }
    }
}