package kr.co.fastcampus.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @author soohwan.ok
 */
private val Context.dataStore by preferencesDataStore(name = "user_datastore")

class UserDataStore @Inject constructor(
    private val context: Context
) {

    companion object {
        private val KEY_TOKEN = stringPreferencesKey("token")
    }

    suspend fun setToken(token: String) {
        context.dataStore.edit { pref ->
            pref[KEY_TOKEN] = token
        }
    }

    suspend fun getToken(): String? {
        return context.dataStore.data.map { it[KEY_TOKEN] }.firstOrNull()
    }

    suspend fun clear() {
        context.dataStore.edit { it.clear() }
    }
}