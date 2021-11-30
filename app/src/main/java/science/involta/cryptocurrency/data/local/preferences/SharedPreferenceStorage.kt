package science.involta.cryptocurrency.data.local.preferences

import android.content.Context

class SharedPreferenceStorage(context: Context) {
    private val preferences = context.getSharedPreferences("COINS_PREFERENCES", Context.MODE_PRIVATE)
}