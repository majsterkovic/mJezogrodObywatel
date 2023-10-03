package pl.mjezogrodobywatel

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import pl.mjezogrodobywatel.databinding.ActivityThirdBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private var name: String? = null
    private val generators: CodeGenerators = CodeGenerators()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityThirdBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        name = intent.getStringExtra("name")


        binding.buttonSecond.setOnClickListener {
            finish()
        }

        // random date in future 50 years
        val date = LocalDate.now().plusDays((Random.nextInt(18250)).toLong()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))


        val map = Data().usersMap

        val imageId = resources.getIdentifier(map[name]!!.zdjecie, "drawable", packageName);
        binding.zdjecie.setImageResource(imageId)
        binding.imie.text = map[name]!!.imie
        binding.nazwisko.text = map[name]!!.nazwisko
        binding.dataUrodzenia.text = map[name]!!.data_urodzenia
        binding.dataWaznosci.text = date
        binding.obywatelstwo.text = map[name]!!.obywatelstwo
        binding.przydzialSernika.text = map[name]!!.przydzial_sernika
        binding.organWydawczy.text = map[name]!!.organ_wydawczy

        binding.kodKreskowy.setImageBitmap(generators.getBarCode128Bitmap("ZWERYFIKOWANO",120, 780 ))
    }
}