package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_MM
import br.com.usinasantafe.cmm.common.utils.TB_EQUIP
import br.com.usinasantafe.cmm.features.infra.models.stable.EquipModel
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMModel

@Dao
interface BoletimMMDao {

    @Query("SELECT * FROM $TB_BOLETIM_MM WHERE statusBolMM = :status")
    suspend fun getBoletim(status: Long): BoletimMMModel

    @Insert
    suspend fun insert(boletimMMModel: BoletimMMModel): Long

}