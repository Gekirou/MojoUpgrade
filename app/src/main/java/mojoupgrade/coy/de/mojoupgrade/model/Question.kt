package mojoupgrade.coy.de.mojoupgrade.model

object QuestionManager {

    val sections: Array<Section>
        get() {
            return Section.values()
        }
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

enum class Section(val questions: List<Question>) {
    BASICS(basicQuestions),
    BDSM(bdsmQuestions),
    ANAL(analQuestions),
    TOYS(toysQuestions),
    GROUP(groupQuestions),
    OTHER(otherQuestions)
}

enum class Gender {
    M,
    F
}
