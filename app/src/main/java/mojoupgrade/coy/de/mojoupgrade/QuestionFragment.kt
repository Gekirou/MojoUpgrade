package mojoupgrade.coy.de.mojoupgrade

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import mojoupgrade.coy.de.mojoupgrade.model.Answer
import mojoupgrade.coy.de.mojoupgrade.model.Question
import mojoupgrade.coy.de.mojoupgrade.model.Section
import mojoupgrade.coy.de.mojoupgrade.ui.CircleIndicator

class QuestionFragment: Fragment() {
    lateinit var section: Section
    lateinit var question: Question
    lateinit var answerCallback: (Answer) -> Unit
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.fragment_interview, container, false)

        inflate.findViewById<CircleIndicator>(R.id.indicator).maxCount = Section.values().size
        inflate.findViewById<CircleIndicator>(R.id.indicator).position = Section.indexOfSection(section)

        inflate.findViewById<TextView>(R.id.question_number_indicator).text = "${section.indexOfQuestion(question) + 1} / ${section.questions.size}"

        inflate.findViewById<TextView>(R.id.question_section_title).text = getString(section.getResourceId(inflater.context))
        inflate.findViewById<TextView>(R.id.interview_title).text = getString(question.getResourceId(inflater.context))

        inflate.findViewById<Button>(R.id.no_button).setOnClickListener { answerCallback.invoke(Answer.NO)}
        inflate.findViewById<Button>(R.id.maybe_button).setOnClickListener { answerCallback.invoke(Answer.MAYBE)}
        inflate.findViewById<Button>(R.id.yes_button).setOnClickListener { answerCallback.invoke(Answer.YES)}

        return inflate
    }

    companion object {
        fun newInstance(section: Section, question: Question, answer: (Answer) -> Unit): QuestionFragment {
            val fragment = QuestionFragment()
            fragment.section = section
            fragment.question = question
            fragment.answerCallback = answer
            return fragment
        }
    }
}