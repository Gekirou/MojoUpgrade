package mojoupgrade.coy.de.mojoupgrade

import android.content.Context
import android.preference.PreferenceManager
import kotlin.reflect.KProperty

data class StringPreference(val context: Context, val userPreference: UserPreference) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        val defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return defaultSharedPreferences.getString(userPreference.key, null)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        val defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return defaultSharedPreferences.edit().putString(userPreference.key, value).apply()
    }
}

enum class UserPreference {
    USER_ID;

    val key: String
        get() = toString()
}