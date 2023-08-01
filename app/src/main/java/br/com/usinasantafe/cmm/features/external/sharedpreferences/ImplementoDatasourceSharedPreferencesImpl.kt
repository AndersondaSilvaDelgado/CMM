package br.com.usinasantafe.cmm.features.external.sharedpreferences

import android.content.SharedPreferences
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_TABLE_CONFIG
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_TABLE_LIST_IMPLEMENTO
import br.com.usinasantafe.cmm.features.domain.entities.variable.Implemento
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ImplementoDatasourceSharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ImplementoDatasourceSharedPreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ImplementoDatasourceSharedPreferences {

    override suspend fun addImplemento(implemento: Implemento): Boolean {
        var data = listImplemento() as MutableList<Implemento>
        data.add(implemento)
        val editor = sharedPreferences.edit()
        val typeToken = object : TypeToken<List<Implemento>>() {}.type
        editor.putString(BASE_SHARE_PREFERENCES_TABLE_LIST_IMPLEMENTO, Gson().toJson(data, typeToken))
        editor.commit()
        data.clear()
        return true
    }



    override suspend fun clearData() {
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_LIST_IMPLEMENTO, null)
        if(!result.isNullOrEmpty()){
            val editor = sharedPreferences.edit()
            editor.putString(BASE_SHARE_PREFERENCES_TABLE_LIST_IMPLEMENTO, null)
            editor.commit()
        }
    }



    override suspend fun countImplemento(): Int {
        var count = 0
        lateinit var data: MutableList<Implemento>
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_LIST_IMPLEMENTO, null)
        if(!result.isNullOrEmpty()){
            val typeToken = object : TypeToken<List<Implemento>>() {}.type
            data = Gson().fromJson(result, typeToken)
            count = data.size
            data.clear()
        }
        return count
    }

    override suspend fun listImplemento(): List<Implemento> {
        var data = mutableListOf<Implemento>()
        val typeToken = object : TypeToken<List<Implemento>>() {}.type
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_LIST_IMPLEMENTO, null)
        if(!result.isNullOrEmpty()){
            data = Gson().fromJson(result, typeToken)
        }
        return data
    }

}