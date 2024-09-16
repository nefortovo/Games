package validator.impl

import validator.api.ITextValidator

class NameValidator: ITextValidator {

    companion object{
        private val NAME_REGEX = "^[A-Za-zА-Яа-я]{2,50}$".toRegex()
    }

    override fun validate(text: String?): Boolean {
        if (text == null) return false
        return NAME_REGEX.matches(text)
    }
}