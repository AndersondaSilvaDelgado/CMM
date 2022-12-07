package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.ROSAtivModel

@Dao
interface ROSAtivDao {

    @Insert
    suspend fun insertAll(vararg rOSAtivModels: ROSAtivModel)

    @Query("DELETE FROM tbrosativest")
    suspend fun deleteAll()

    @Query("SELECT * FROM tbrosativest WHERE idOS = :idOS")
    suspend fun listIdOS(idOS: Long): List<ROSAtivModel>

}