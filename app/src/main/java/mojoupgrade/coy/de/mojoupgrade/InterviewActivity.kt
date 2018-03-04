package mojoupgrade.coy.de.mojoupgrade

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import mojoupgrade.coy.de.mojoupgrade.model.Answer
import mojoupgrade.coy.de.mojoupgrade.model.Question
import mojoupgrade.coy.de.mojoupgrade.model.Section

class InterviewActivity : AppCompatActivity() {

    val currentSectionIterator = Section.values().iterator()
    var currentQuestionIterator: Iterator<Question>? = null
    val answers = mutableMapOf<Question, Answer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_root_interview)

        moveToNextSection()
    }

    private fun moveToNextSection() {
        if (currentSectionIterator.hasNext()) {
            val next = currentSectionIterator.next()
            currentQuestionIterator = next.questions.iterator()
            presentSectionFragment(next)
        }
    }

    private fun presentSectionFragment(section: Section) {
        val fragment = SectionFragment.newInstance(section)

        fragment.enterTransition = Fade(Fade.MODE_IN)
        fragment.exitTransition = Fade(Fade.MODE_OUT)
        fragment.allowEnterTransitionOverlap = false
        fragment.allowReturnTransitionOverlap = false

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.root_interview, fragment)
                .commit()

        launch {
            delay(SECTION_SHOW_TIME)
            runOnUiThread {
                moveToNextQuestion(section)
            }
        }
    }

    private fun moveToNextQuestion(section: Section) {
        if (currentQuestionIterator?.hasNext() == true) {
            currentQuestionIterator?.next()?.let {
                presentQuestionFragment(section, it)
            }
        } else {
            moveToNextSection()
        }
    }

    private fun presentQuestionFragment(section: Section, question: Question) {
        val fragment = QuestionFragment.newInstance(section, question) {
            answers[question] = it
            moveToNextQuestion(section)
        }

        fragment.enterTransition = Fade(Fade.MODE_IN)
        fragment.exitTransition = Fade(Fade.MODE_OUT)
        fragment.allowEnterTransitionOverlap = false
        fragment.allowReturnTransitionOverlap = false

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.root_interview, fragment)
                .commit()
    }

    companion object {
        val SECTION_SHOW_TIME = 3000
    }

}