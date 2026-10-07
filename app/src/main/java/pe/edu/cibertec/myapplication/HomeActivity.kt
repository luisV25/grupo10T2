package pe.edu.cibertec.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import pe.edu.cibertec.myapplication.databinding.ActivityHomeBinding
import pe.edu.cibertec.myapplication.fragments.Pregunta1Fragment
import pe.edu.cibertec.myapplication.fragments.Pregunta2Fragment
import pe.edu.cibertec.myapplication.fragments.Pregunta3Fragment
import pe.edu.cibertec.myapplication.fragments.Pregunta4Fragment

class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // El listener se inicializa en onCreate
        binding.bottomNavigation.setOnItemSelectedListener(this)

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.nav_pregunta1
        }
    }

    override fun onNavigationItemSelected(item: android.view.MenuItem): Boolean {
        val fragment: Fragment = when (item.itemId) {
            R.id.nav_pregunta1 -> Pregunta1Fragment()
            R.id.nav_pregunta2 -> Pregunta2Fragment()
            R.id.nav_pregunta3 -> Pregunta3Fragment()
            R.id.nav_pregunta4 -> Pregunta4Fragment()
            else -> return false
        } as Fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
        return true
    }
}
