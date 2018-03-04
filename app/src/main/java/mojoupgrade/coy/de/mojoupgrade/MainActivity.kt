package mojoupgrade.coy.de.mojoupgrade

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    var userId by StringPreference(this, UserPreference.USER_ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_session)

        val sessionsReference = FirebaseDatabase.getInstance().getReference("sessions")
        val usersReference = FirebaseDatabase.getInstance().getReference("users")

        if (userId == null) {
            val key = usersReference.push().key
            userId = key
        }

        findViewById<Button>(R.id.button_start_new_session).setOnClickListener {
            val sessionKey = sessionsReference.push().key
            startActivity(SetupUserActivity.newIntent(this, sessionKey))
        }
    }
}
