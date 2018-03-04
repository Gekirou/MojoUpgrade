package mojoupgrade.coy.de.mojoupgrade.model

import android.content.Context

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
) {
    fun getResourceId(context: Context): Int {
        return context.resources.getIdentifier(key, "string", context.packageName)
    }
}

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
    OTHER(otherQuestions);

    fun getResourceId(context: Context): Int {
        return context.resources.getIdentifier("section_${name.toLowerCase()}_title", "string", context.packageName)
    }

    fun indexOfQuestion(question: Question): Int {
        return questions.indexOfFirst { it.key == question.key }
    }

    companion object {

        fun indexOfSection(section: Section): Int {
            return Section.values().indexOfFirst { it == section }
        }

    }
}

enum class Gender {
    M,
    F
}
