import games.game_launcher.GameLauncher
import greeting.Greeting

fun main() {
    val greeting = Greeting()

    greeting.askName()


    val gameLauncher = GameLauncher()

    val game = gameLauncher.chooseGame()

    repeat(3){
        game.startGame()
    }

    game.stopGame()

}