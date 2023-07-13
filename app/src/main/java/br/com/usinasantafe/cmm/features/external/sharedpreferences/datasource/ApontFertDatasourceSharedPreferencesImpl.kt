package br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource

import android.content.SharedPreferences
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_TABLE_APONT_FERT
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_TABLE_APONT_MM
import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontFert
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ApontFertDatasourceSharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

class ApontFertDatasourceSharedPreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ApontFertDatasourceSharedPreferences {

    override suspend fun getApontFert(): ApontFert {
        var apont = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_APONT_FERT, null)!!
        return Gson().fromJson(apont, ApontFert::class.java)
    }

    override suspend fun setIdAtiv(idAtiv: Long): Boolean {
        if (checkApont()) {
            return false
        }
        var apont = getApontFert()
        apont.idAtivApont = idAtiv
        saveApont(apont)
        return true
    }

    override suspend fun setIdParada(idParada: Long): Boolean {
        if (checkApont()) {
            return false
        }
        var apont = getApontFert()
        apont.idParadaApont = idParada
        saveApont(apont)
        return true
    }

    override suspend fun setNroOS(nroOS: Long): Boolean {
        if (checkApont()) {
            return false
        }
        var apont = getApontFert()
        apont.nroOSApont = nroOS
        saveApont(apont)
        return true
    }

    override suspend fun startApont(
        typeNote: TypeNote,
        idBoletim: Long,
        nroOS: Long?,
        idAtiv: Long?
    ): Boolean {
        var apont = ApontFert()
        apont.idBolApont = idBoletim
        apont.tipoApont = typeNote
        apont.nroOSApont = nroOS
        apont.idAtivApont = idAtiv
        saveApont(apont)
        return true
    }

    private fun checkApont(): Boolean {
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_APONT_MM, null)
        return result == null
    }

    private fun saveApont(apont: ApontFert) {
        val editor = sharedPreferences.edit()
        editor.putString(BASE_SHARE_PREFERENCES_TABLE_APONT_FERT, Gson().toJson(apont))
        editor.commit()
    }

}