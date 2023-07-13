package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_FERT
import br.com.usinasantafe.cmm.features.infra.models.room.variable.BoletimFertRoomModel

@Dao
interface BoletimFertDao {

    @Query("SELECT * FROM $TB_BOLETIM_FERT WHERE statusBolFert = :status")
    suspend fun getBoletimStatus(status: StatusData): BoletimFertRoomModel

    @Insert
    suspend fun insert(boletimFertRoomModel: BoletimFertRoomModel): Long

}