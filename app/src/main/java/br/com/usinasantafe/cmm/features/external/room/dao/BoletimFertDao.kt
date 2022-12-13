package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_FERT
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_MM
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimFertModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMModel

@Dao
interface BoletimFertDao {

    @Query("SELECT * FROM $TB_BOLETIM_FERT WHERE statusBolFert = :status")
    suspend fun getBoletim(status: Long): BoletimFertModel

    @Insert
    suspend fun insert(boletimFertModel: BoletimFertModel): Long

}