package science.involta.cryptocurrency

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: AppCompatActivity ()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainBottomNavigationHostFragment) as? NavHostFragment ?: return
        val navController = findNavController(R.id.mainBottomNavigationHostFragment)

        val mainBottomNavigationView = findViewById<BottomNavigationView>(R.id.mainBottomNavigationView)
        mainBottomNavigationView.setupWithNavController(navController)


    }
}