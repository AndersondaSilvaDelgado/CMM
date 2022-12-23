package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_R_FUNCAO_ATIV_PARADA
import br.com.usinasantafe.cmm.features.infra.models.stable.RFuncaoAtivParadaModel

@Dao
interface RFuncaoAtivParadaDao {

    @Query("SELECT * FROM $TB_R_FUNCAO_ATIV_PARADA WHERE idAtivPar = :idAtiv AND tipoFuncao = 1")
    suspend fun listRFuncaoAtiv(idAtiv: Long): List<RFuncaoAtivParadaModel>

    @Insert
    suspend fun insertAll(vararg rFuncaoAtivParadaModel: RFuncaoAtivParadaModel)

    @Query("DELETE FROM $TB_R_FUNCAO_ATIV_PARADA")
    suspend fun deleteAll()

}