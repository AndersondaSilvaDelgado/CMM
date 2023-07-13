package br.com.usinasantafe.cmm.features.external.sharedpreferences.datasource

import android.content.SharedPreferences
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_TABLE_APONT_MM
import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ApontMMDatasourceSharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

class ApontMMDatasourceSharedPreferencesImpl @Inject constructor (
    private val sharedPreferences: SharedPreferences
): ApontMMDatasourceSharedPreferences {

    override suspend fun getApontMM(): ApontMM {
        var apont = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_APONT_MM, null)!!
        return Gson().fromJson(apont, ApontMM::class.java)
    }

    override suspend fun setIdAtiv(idAtiv: Long): Boolean {
        if(checkApont()){
            return false
        }
        var apont = getApontMM()
        apont.idAtivApont = idAtiv
        saveApont(apont)
        return true
    }

    override suspend fun setIdParada(idParada: Long): Boolean {
        if(checkApont()){
            return false
        }
        var apont = getApontMM()
        apont.idParadaApont = idParada
        saveApont(apont)
        return true
    }

    override suspend fun setNroOS(nroOS: Long): Boolean {
        if(checkApont()){
            return false
        }
        var apont = getApontMM()
        apont.nroOSApont = nroOS
        saveApont(apont)
        return true
    }

    override suspend fun startApont(typeNote: TypeNote, idBoletim: Long, nroOS: Long?, idAtiv: Long?): Boolean {
        var apont = ApontMM()
        apont.idBolApont = idBoletim
        apont.tipoApont = typeNote
        apont.nroOSApont = nroOS
        apont.idAtivApont = idAtiv
        saveApont(apont)
        return true
    }

    private fun checkApont(): Boolean{
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_APONT_MM, null)
        return result == null
    }

    private fun saveApont(apont: ApontMM) {
        val editor = sharedPreferences.edit()
        editor.putString(BASE_SHARE_PREFERENCES_TABLE_APONT_MM, Gson().toJson(apont))
        editor.commit()
    }

}