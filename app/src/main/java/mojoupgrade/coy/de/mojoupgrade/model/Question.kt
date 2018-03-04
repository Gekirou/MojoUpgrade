package mojoupgrade.coy.de.mojoupgrade.model

object QuestionManager {

}

class Question(
        val key: String,
        val partnerKey: String? = null,
        val userGenders: Array<Gender> = Gender.values(),
        val partnerGenders: Array<Gender> = Gender.values()
)

data class AnsweredQuestion(val questionKey: String, val answer: Answer)

enum class Answer {
    YES,
    MAYBE,
    NO
}

enum class Section {
    BASICS,
    BDSM,
    ANAL,
    TOYS,
    GROUP,
    OTHER
}

enum class Gender {
    M,
    F
}
