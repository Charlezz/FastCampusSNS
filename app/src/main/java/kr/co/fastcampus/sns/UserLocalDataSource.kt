package kr.co.fastcampus.sns

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * @author soohwan.ok
 */
private const val USER_PREFERENCES_NAME = "user_preferences"
private val Context.dataStore by preferencesDataStore(name = USER_PREFERENCES_NAME)
class UserLocalDataSource constructor(
    private val context: Context
) {

    companion object{
        private val KEY_TOKEN = stringPreferencesKey("token")
    }

    suspend fun getToken(): String? {
        return context.dataStore.data.map { it[KEY_TOKEN] }.first()
    }

    suspend fun setToken(token:String){
        context.dataStore.edit { it[KEY_TOKEN] = token }
    }

    suspend fun clear(){
        context.dataStore.edit { it.clear() }
    }


}