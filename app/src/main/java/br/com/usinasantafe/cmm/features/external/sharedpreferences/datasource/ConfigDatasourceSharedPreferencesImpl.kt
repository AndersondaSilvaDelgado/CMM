package br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource

import android.content.SharedPreferences
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_EQUIP
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_SENHA
import br.com.usinasantafe.cmm.features.domain.entities.Config
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ConfigDatasourceSharedPreferences
import javax.inject.Inject

class ConfigDatasourceSharedPreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ConfigDatasourceSharedPreferences {

    override suspend fun hasSenhaConfig(): Boolean {
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_SENHA, null)
        return result != null
    }

    override suspend fun senhaConfig(): String {
        return sharedPreferences.getString(BASE_SHARE_PREFERENCES_SENHA, null)!!
    }

    override suspend fun getConfig(): Config {
        return Config(
            sharedPreferences.getLong(BASE_SHARE_PREFERENCES_EQUIP, 0L),
            sharedPreferences.getString(BASE_SHARE_PREFERENCES_SENHA, null)!!,
        )
    }

    override suspend fun saveConfig(config: Config) {
        val editor = sharedPreferences.edit()
        editor.putLong(BASE_SHARE_PREFERENCES_EQUIP, config.equipConfig)
        editor.putString(BASE_SHARE_PREFERENCES_SENHA, config.senhaConfig)
        editor.commit()
    }

}