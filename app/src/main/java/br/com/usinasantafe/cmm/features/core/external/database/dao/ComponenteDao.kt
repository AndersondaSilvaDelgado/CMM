package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.ComponenteModel

@Dao
interface ComponenteDao {

    @Insert
    suspend fun insert(componenteModel: ComponenteModel): Long

    @Query("DELETE FROM tbcomponenteest")
    suspend fun deleteAll()

}