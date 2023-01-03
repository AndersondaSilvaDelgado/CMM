package br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource

import android.content.SharedPreferences
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_EQUIP
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_SENHA
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_STATUS_ENVIO
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ConfigDatasourceSharedPreferences
import javax.inject.Inject

class ConfigDatasourceSharedPreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ConfigDatasourceSharedPreferences {

    override suspend fun hasSenhaConfig(): Boolean {
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_SENHA, null)
        return result != null
    }

    override suspend fun getConfig(): Config {
        return Config(
            sharedPreferences.getLong(BASE_SHARE_PREFERENCES_EQUIP, 0L),
            sharedPreferences.getString(BASE_SHARE_PREFERENCES_SENHA, null)!!,
            StatusSend.values()[sharedPreferences.getLong(BASE_SHARE_PREFERENCES_STATUS_ENVIO, StatusSend.ENVIADO.ordinal.toLong()).toInt()],
        )
    }

    override suspend fun saveConfig(config: Config) {
        val editor = sharedPreferences.edit()
        editor.putLong(BASE_SHARE_PREFERENCES_EQUIP, config.equipConfig)
        editor.putString(BASE_SHARE_PREFERENCES_SENHA, config.senhaConfig)
        editor.putLong(BASE_SHARE_PREFERENCES_STATUS_ENVIO, config.statusEnvio.ordinal.toLong())
        editor.commit()
    }

    override suspend fun setStatusSend(statusSend: StatusSend) {
        val editor = sharedPreferences.edit()
        editor.putLong(BASE_SHARE_PREFERENCES_STATUS_ENVIO, statusSend.ordinal.toLong())
        editor.commit()
    }

}