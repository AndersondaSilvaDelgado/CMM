package br.com.usinasantafe.cmm.features.external.sharedpreferences

import android.content.SharedPreferences
import br.com.usinasantafe.cmm.common.utils.BASE_SHARE_PREFERENCES_TABLE_BOLETIM_FERT
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimFert
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.BoletimFertDatasourceSharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

class BoletimFertDatasourceSharedPreferencesImpl @Inject constructor (
    private val sharedPreferences: SharedPreferences
): BoletimFertDatasourceSharedPreferences {

    override suspend fun clearBoletim() {
        val editor = sharedPreferences.edit()
        editor.putString(BASE_SHARE_PREFERENCES_TABLE_BOLETIM_FERT, Gson().toJson(BoletimFert()))
        editor.commit()
    }

    override suspend fun getBoletimFert(): BoletimFert {
        var boletim = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_BOLETIM_FERT, null)!!
        return Gson().fromJson(boletim, BoletimFert::class.java)
    }

    override suspend fun setHorimetroInicial(horimetroInicial: Double): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimFert()
        boletim.hodometroInicialBol = horimetroInicial
        saveBoletim(boletim)
        return true
    }

    override suspend fun setIdAtiv(idAtiv: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimFert()
        boletim.idAtivBol = idAtiv
        saveBoletim(boletim)
        return true
    }

    override suspend fun setIdTurno(idTurno: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimFert()
        boletim.idTurnoBol = idTurno
        saveBoletim(boletim)
        return true
    }

    override suspend fun setMatricOperador(nroMatric: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimFert()
        boletim.matricFuncBol = nroMatric
        saveBoletim(boletim)
        return true
    }

    override suspend fun setNroOS(nroOS: Long): Boolean {
        if(checkBoletim()){
            return false
        }
        var boletim = getBoletimFert()
        boletim.nroOSBol = nroOS
        saveBoletim(boletim)
        return true
    }

    override suspend fun startBoletim(idEquip: Long): Boolean {
        var boletim = BoletimFert()
        boletim.statusBol = StatusData.INITIATE
        boletim.idEquipBol = idEquip
        saveBoletim(boletim)
        return true
    }

    private fun checkBoletim(): Boolean{
        val result = sharedPreferences.getString(BASE_SHARE_PREFERENCES_TABLE_BOLETIM_FERT, null)
        return result == null
    }

    private fun saveBoletim(boletimFert: BoletimFert) {
        val editor = sharedPreferences.edit()
        editor.putString(BASE_SHARE_PREFERENCES_TABLE_BOLETIM_FERT, Gson().toJson(boletimFert))
        editor.commit()
    }

}