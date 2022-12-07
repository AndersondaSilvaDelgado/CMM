package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.ProdutoModel

@Dao
interface ProdutoDao {

    @Insert
    suspend fun insertAll(vararg produtoModels: ProdutoModel)

    @Query("DELETE FROM tbprodutoest")
    suspend fun deleteAll()

}