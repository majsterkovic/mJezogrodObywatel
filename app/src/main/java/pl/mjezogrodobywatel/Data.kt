package pl.mjezogrodobywatel
import kotlin.random.Random

class Data {
    var usersMap = HashMap<String, Obywatel>()

    init {
        val numbersList = arrayListOf<String>()
        numbersList.addAll(listOf("21,37", "69", "666", "0,001", "0", "-1"))
        val ran = Random
        val extraRandoms  = IntArray(6) { ran.nextInt(9) + 1 }.asList()

        extraRandoms.forEach {
            numbersList.add(it.toString())
        }

        val organ: String = "Biuro Administracyjne P. J."

        usersMap["Grzegorzewski"] =
            Obywatel("jg","J", "G", "01-10-2001", "Jeżogrodzkie", numbersList.random(), organ, "01-01-2077")
        usersMap["Witwicki"] =
            Obywatel("lw","Ł", "W", "01-01-2001", "Jeżogrodzkie", numbersList.random(), organ, "01-01-2077")
        usersMap["Hybiak"] =
            Obywatel("mh","M", "H", "01-01-2001", "Jeżogrodzkie", numbersList.random(), organ, "01-01-2077")
        usersMap["Pietras"] =
            Obywatel("mp", "M", "P", "01-01-2001", "Jeżogrodzkie", numbersList.random(), organ, "01-01-2077")
    }

}