package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.ComponenteModel

@Dao
interface ComponenteDao {

    @Insert
    suspend fun insert(componenteModel: ComponenteModel): Long

    @Query("DELETE FROM tbcomponenteest")
    suspend fun deleteAll()

}