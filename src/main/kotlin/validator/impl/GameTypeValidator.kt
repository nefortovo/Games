package validator.impl

import validator.api.ITextValidator

class GameTypeValidator: ITextValidator {
    companion object{
        private val NAME_REGEX = "^[1-2]$".toRegex()
    }

    override fun validate(text: String?): Boolean {
        if (text == null) return false
        return NAME_REGEX.matches(text)
    }
}