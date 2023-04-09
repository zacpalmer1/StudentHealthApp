package edu.cofc.andriod.cofchealthapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import edu.cofc.andriod.cofchealthapp.databinding.ActivityMainBinding
import edu.cofc.andriod.cofchealthapp.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    var output = " "
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){

                R.id.home -> replaceFragment(Home())
                R.id.search -> replaceFragment(Search())
                R.id.post -> replaceFragment(Post())
                R.id.wellness -> replaceFragment(Wellness())
                R.id.profile -> replaceFragment(Profile())

                else ->{

                }
            }
            true
        }

        }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}