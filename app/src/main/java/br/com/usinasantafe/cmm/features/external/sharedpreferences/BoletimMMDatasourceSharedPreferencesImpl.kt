package br.com.usinasantafe.cmm.features.external.sharedpreferences

import android.content.SharedPreferences
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_TABLE_BOLETIM_MM
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.BoletimMMDatasourceSharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

class BoletimMMDatasourceSharedPreferencesImpl @Inject constructor (
    private val sharedPreferences: SharedPreferences
): BoletimMMDatasourceSharedPreferences {

    override suspend fun clearBoletim() {
        val editor = sharedPreferences.edit()
        editor.putString(BASE_SHARE_PREFERENCES_TABLE_BOLETIM_MM, Gson().toJson(BoletimMM()))
        editor.commit()
    }

    override suspend fun getBoletimMM(): BoletimMM {
        var boletim = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_BOLETIM_MM, null)!!
        return Gson().fromJson(boletim, BoletimMM::class.java)
    }

    override suspend fun setHorimetroInicial(horimetroInicial: Double): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimMM()
        boletim.hodometroInicialBol = horimetroInicial
        saveBoletim(boletim)
        return true
    }

    override suspend fun setIdAtiv(idAtiv: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimMM()
        boletim.idAtivBol = idAtiv
        saveBoletim(boletim)
        return true
    }

    override suspend fun setIdTurno(idTurno: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimMM()
        boletim.idTurnoBol = idTurno
        saveBoletim(boletim)
        return true
    }

    override suspend fun setMatricOperador(nroMatric: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimMM()
        boletim.matricFuncBol = nroMatric
        saveBoletim(boletim)
        return true
    }

    override suspend fun setNroOS(nroOS: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimMM()
        boletim.nroOSBol = nroOS
        saveBoletim(boletim)
        return true
    }

    override suspend fun startBoletim(idEquip: Long): Boolean {
        var boletim = BoletimMM()
        boletim.statusBol = StatusData.INITIATE
        boletim.idEquipBol = idEquip
        saveBoletim(boletim)
        return true
    }

    private fun checkBoletim(): Boolean{
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_BOLETIM_MM, null)
        return result == null
    }

    private fun saveBoletim(boletim: BoletimMM) {
        val editor = sharedPreferences.edit()
        editor.putString(BASE_SHARE_PREFERENCES_TABLE_BOLETIM_MM, Gson().toJson(boletim))
        editor.commit()
    }

}