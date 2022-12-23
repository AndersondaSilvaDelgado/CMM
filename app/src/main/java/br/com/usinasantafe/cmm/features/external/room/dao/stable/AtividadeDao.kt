package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_ATIVIDADE
import br.com.usinasantafe.cmm.features.infra.models.stable.AtividadeModel

@Dao
interface AtividadeDao {

    @Insert
    fun insertAll(vararg atividadeModels: AtividadeModel)

    @Query("DELETE FROM $TB_ATIVIDADE")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_ATIVIDADE WHERE idAtiv IN (:idAtivs)")
    suspend fun listInIdAtiv(vararg idAtivs: Long): List<AtividadeModel>

}