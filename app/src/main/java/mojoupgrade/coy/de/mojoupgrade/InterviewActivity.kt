package mojoupgrade.coy.de.mojoupgrade

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mojoupgrade.coy.de.mojoupgrade.model.Section

class InterviewActivity : AppCompatActivity() {

    val currentSectionIterator = Section.values().iterator()
    var currentSection: Section? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_root_interview)

        moveToNextSection()
    }

    private fun moveToNextSection() {
        if (currentSectionIterator.hasNext()) {
            currentSection = currentSectionIterator.next()
        }
        presentSectionFragment()
    }

    private fun presentSectionFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.root_interview, QuestionFragment())
                .commit()
    }

    private fun moveToNextQuestion() {

    }
}