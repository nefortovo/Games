package games.geometric_progression

import games.api.Game
import kotlin.math.pow
import kotlin.random.Random

class GeomerticProgression: Game {
    // Генерация геометрической прогрессии
    private fun generateProgression(length: Int, ratio: Int): List<Int> {
        return List(length) { index -> 1 * ratio.pow(index) }
    }

    // Скрытие элемента в прогрессии
    private fun hideElement(progression: List<Int>): Pair<List<String>, Int> {
        val hiddenIndex = Random.nextInt(progression.size)
        val hiddenElement = progression[hiddenIndex]
        val progressionWithMissing = progression.mapIndexed { index, value ->
            if (index == hiddenIndex) ".." else value.toString()
        }
        return Pair(progressionWithMissing, hiddenElement)
    }

    // Расширение для возведения в степень
    private fun Int.pow(exponent: Int): Int = toDouble().pow(exponent).toInt()

    // Форматирование прогрессии в строку
    private fun formatProgression(progression: List<String>): String =
        progression.joinToString(" ")

    // Проверка правильности ответа
    private fun checkAnswer(userAnswer: String, correctAnswer: String): Boolean =
        userAnswer == correctAnswer

    // Логика игры
    override fun startGame() {
        val length = Random.nextInt(5, 11) // Длина прогрессии от 5 до 10 чисел
        val ratio = Random.nextInt(2, 6)   // Генерация случайного множителя от 2 до 5
        val progression = generateProgression(length, ratio)
        val (progressionWithMissing, hiddenElement) = hideElement(progression)

        // Вывод вопроса
        val formattedProgression = formatProgression(progressionWithMissing)
        println("What number is missing in the progression?")
        println("Question: $formattedProgression")

        // Здесь вместо считывания ответа от пользователя добавьте свою логику
        // Для примера, предположим, что мы получаем ответ от метода или теста
        println("Please enter your answer:")
        val userAnswer = getUserAnswer()

        // Проверка ответа и вывод результата
        if (checkAnswer(userAnswer, hiddenElement.toString())) {
            println("Correct!")
        } else {
            println("'$userAnswer' is wrong answer ;(. Correct answer was '$hiddenElement'.")
            println("Let's try again!")
        }
    }

    private fun getUserAnswer(): String {
        return readln()
    }

    override fun stopGame() {
        println("See you later!")
        return
    }
}