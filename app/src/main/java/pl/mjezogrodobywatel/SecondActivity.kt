package pl.mjezogrodobywatel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import pl.mjezogrodobywatel.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private var name: String? = null
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        name = intent.getStringExtra("name")
        val imie = Data().usersMap[name]?.imie
        Toast.makeText(this, "Udane logowanie $imie", Toast.LENGTH_LONG).show()


        binding.mKarta.setOnClickListener {
            // start third activity
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }

        binding.sos.setOnClickListener {
            // start fourth activity
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }
}