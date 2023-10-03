package pl.mjezogrodobywatel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import pl.mjezogrodobywatel.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var name: String


    override fun onCreate(savedInstanceState: Bundle?) {

        this.supportActionBar?.title = "Logowanie"

        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.editTextTextPersonName.hint = "Wprowadź nazwisko"
        binding.editTextTextPersonName.setOnFocusChangeListener { _, _ ->
            binding.editTextTextPersonName.hint = ""
        }


        binding.button.setOnClickListener {
            name = binding.editTextTextPersonName.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(this, "Wprowadź nazwisko", Toast.LENGTH_SHORT).show()
            } else if (name !in listOf("Grzegorzewski", "Witwicki", "Pietras", "Hybiak")) {
                Toast.makeText(this, "Nie jesteś obywatelem Jeżogrodu", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            }
        }

    }


}