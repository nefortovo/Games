package games.game_launcher

import games.api.Game
import games.geometric_progression.GeomerticProgression
import games.lcm.LCM
import validator.impl.GameTypeValidator

class GameLauncher {

    private val gameTypeValidator = GameTypeValidator()
    private var gameNumber: String? = null

    fun chooseGame(): Game {
        println(
            "Let's choose the game\n" +
                    "1 - наименьшее общее кратное (НОК)\n" +
                    "2 - Геометическая прогрессия"
        )

        gameNumber = readln()

        while (!gameTypeValidator.validate(gameNumber)) {
            println("Unknown game number, please try again <3\n")
            gameNumber = readln()
        }
        return when(gameNumber){
            "1" -> {
                LCM()
            }
            "2" -> {
                GeomerticProgression()
            }
            else -> throw IllegalArgumentException("Unknown game number")
        }

    }

}