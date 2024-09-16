package greeting

import validator.impl.NameValidator

class Greeting {

    private var name: String? = null
    private val nameValidator = NameValidator()

    fun askName() {
        println("Welcome to the Brain Games! May I have your name?")

        name = readln()

        while (!nameValidator.validate(name)) {
            println("Incorrect player name, please try again <3\n")
            name = readln()
        }

        println("Welcome to the Brain Games, $name!")
    }

}