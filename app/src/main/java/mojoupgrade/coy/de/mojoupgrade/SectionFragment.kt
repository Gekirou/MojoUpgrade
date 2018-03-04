package mojoupgrade.coy.de.mojoupgrade

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mojoupgrade.coy.de.mojoupgrade.model.Section

class SectionFragment: Fragment() {

    private lateinit var section: Section

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_section_title, container, false)
        val resourceId = context?.let { section.getResourceId(it) } ?: 0
        view.findViewById<TextView>(R.id.section_title).text = getString(resourceId)
        return view
    }

    companion object {
        fun newInstance(section: Section): SectionFragment {
            val fragment = SectionFragment()
            fragment.section = section
            return fragment
        }
    }
}