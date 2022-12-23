package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_PROPRIEDADE
import br.com.usinasantafe.cmm.features.infra.models.stable.PropriedadeModel

@Dao
interface PropriedadeDao {

    @Insert
    suspend fun insertAll(vararg propriedadeModels: PropriedadeModel)

    @Query("DELETE FROM $TB_PROPRIEDADE")
    suspend fun deleteAll()

}