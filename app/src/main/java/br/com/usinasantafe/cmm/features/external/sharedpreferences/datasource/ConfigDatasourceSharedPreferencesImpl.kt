package br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource

import android.content.SharedPreferences
import br.com.usinasantafe.cmm.common.utils.*
import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ConfigDatasourceSharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

class ConfigDatasourceSharedPreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ConfigDatasourceSharedPreferences {

    override suspend fun hasConfig(): Boolean {
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_CONFIG, null)
        return result != null
    }

    override suspend fun getConfig(): Config {
        var config = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_CONFIG, null)!!
        return Gson().fromJson(config, Config::class.java)
    }

    override suspend fun saveConfig(config: Config) {
        val editor = sharedPreferences.edit()
        editor.putString(BASE_SHARE_PREFERENCES_TABLE_CONFIG, Gson().toJson(config))
        editor.commit()
    }

    override suspend fun setStatusSend(statusSend: StatusSend) {
        var config = getConfig()
        config.statusEnvio = statusSend
        saveConfig(config)
    }

}