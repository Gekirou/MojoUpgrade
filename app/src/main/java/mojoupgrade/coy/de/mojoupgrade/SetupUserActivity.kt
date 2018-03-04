package mojoupgrade.coy.de.mojoupgrade

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.NumberPicker

class SetupUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_setup_user)

        val age = findViewById<NumberPicker>(R.id.numberPicker)
        age.minValue = 18
        age.maxValue = 100
        age.displayedValues = (18..100).asSequence().map { it.toString() }.toList().toTypedArray()
        age.wrapSelectorWheel = false

        findViewById<Button>(R.id.usersetup_start).setOnClickListener {
            startActivity(Intent(this, InterviewActivity::class.java))
        }
    }

    companion object {

        private val INTENT_SESSION_ID = "session_id"

        fun newIntent(context: Context, sessionId: String): Intent {
            val intent = Intent(context, SetupUserActivity::class.java)
            intent.putExtra(INTENT_SESSION_ID, sessionId)
            return intent
        }
    }
}