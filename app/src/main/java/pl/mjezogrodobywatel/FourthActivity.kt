package pl.mjezogrodobywatel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.mjezogrodobywatel.databinding.ActivityFourthBinding
import pl.mjezogrodobywatel.CodeGenerators
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.pow
import kotlin.random.Random

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding
    private var name: String? = null
    private val generators: CodeGenerators = CodeGenerators()

    private fun generateRandomNumber(isEven: Boolean, howLong: Int) : Int {
        val from = (10.0.pow(howLong - 1)).toInt()
        val to = (10.0.pow(howLong )- 1.0).toInt()
        var randomNumber = Random.nextInt(to - from + 1) + from
        if (isEven) {
            while (randomNumber % 2 != 0) {
                randomNumber = Random.nextInt(to - from + 1) + from
            }
        } else {
            while (randomNumber % 2 == 0) {
                randomNumber = Random.nextInt(to - from + 1) + from
            }
        }
        return randomNumber
    }


    private fun birthDateToPesel(birthDate: String, sex: String) : String {
        val day = birthDate.substring(0, 2)
        var month = birthDate.substring(3, 5)
        val year = birthDate.substring(6, 10)
        month = (month.toInt() + 20).toString()

        val pppp = if (sex.last() == 'a') {
            generateRandomNumber(true, 4).toString()
        } else {
            generateRandomNumber(false, 4).toString()
        }

        return year.substring(2,4) + month + day + pppp + Random.nextInt(10).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        name = intent.getStringExtra("name")
        val user = Data().usersMap[name]!!
        super.onCreate(savedInstanceState)

        binding = ActivityFourthBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        val kod = Random.nextInt(9999 - 1000) + 1000

        binding.kodRecepty.text = kod.toString()
        binding.qrCode.setImageBitmap(generators.getQrCodeBitmap(kod.toString() + "\n" + birthDateToPesel(user.data_urodzenia, user.imie), 720))

        binding.buttonSecond.setOnClickListener {
            finish()
        }

        val lekarzLekLista = listOf(
            Pair("M P", "Sos czosnkowy"),
            Pair("M H", "Temerski Syn"),
            Pair("Ł W", "Kremówki 500"),
            Pair("J G", "Farmaceutyczne kiełbasy")
        )

        val lekarzLek = lekarzLekLista.random()
        binding.lekarz.text = lekarzLek.first
        binding.lek.text = lekarzLek.second

        // random date
        val date = LocalDate.now().minusDays((Random.nextInt(30)).toLong()).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        binding.dataWystawienia.text = date

    }


}