package mojoupgrade.coy.de.mojoupgrade

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.NumberPicker

class InterviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_root_interview)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.root_interview, QuestionFragment())
                .commit()
    }
}