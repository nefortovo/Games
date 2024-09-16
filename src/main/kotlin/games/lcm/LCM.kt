package games.lcm

import games.api.Game

class LCM : Game {

    private fun lcm(a: Int, b: Int): Int {
        var max = if (a > b) a else b
        while (true) {
            if (max % a == 0 && max % b == 0) {
                return max
            }
            max++
        }
    }

    private fun lcmOfThree(a: Int, b: Int, c: Int): Int {
        val lcmAB = lcm(a, b)
        return lcm(lcmAB, c)
    }

    override fun startGame() {
        val num1 = (1..20).random()
        val num2 = (1..20).random()
        val num3 = (1..20).random()

        val correctAnswer = lcmOfThree(num1, num2, num3).toString()

        println("Question: $num1 $num2 $num3")
        print("Your answer: ")
        val userAnswer = readln()

        if (userAnswer == correctAnswer) {
            println("Correct!")
        } else {
            println("'$userAnswer' is wrong answer ;(. Correct answer was '$correctAnswer'.")
            println("Let's try again!")
        }
    }

    override fun stopGame() {
        println("See you later!")
        return
    }
}