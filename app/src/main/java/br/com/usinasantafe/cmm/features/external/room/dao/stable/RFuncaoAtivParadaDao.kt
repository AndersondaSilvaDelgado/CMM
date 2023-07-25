package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_R_FUNCAO_ATIV_PARADA
import br.com.usinasantafe.cmm.features.infra.models.room.stable.RFuncaoAtivParadaRoomModel

@Dao
interface RFuncaoAtivParadaDao {

    @Insert
    suspend fun insertAll(vararg rFuncaoAtivParadaRoomModel: RFuncaoAtivParadaRoomModel)

    @Query("DELETE FROM $TB_R_FUNCAO_ATIV_PARADA")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TB_R_FUNCAO_ATIV_PARADA WHERE idAtivPar = :idAtiv AND tipoFuncao = :tipoFuncao")
    suspend fun listRFuncaoIdAtivTipo(idAtiv: Long, tipoFuncao: Long): List<RFuncaoAtivParadaRoomModel>

    @Query("SELECT * FROM $TB_R_FUNCAO_ATIV_PARADA WHERE codFuncao = :codFuncao AND tipoFuncao = :tipoFuncao")
    suspend fun getRFuncaoAtivParadaCodTipo(codFuncao: Long, tipoFuncao: Long): RFuncaoAtivParadaRoomModel

    @Query("SELECT * FROM $TB_R_FUNCAO_ATIV_PARADA WHERE idAtivPar = :idAtiv AND tipoFuncao = :tipoFuncao AND codFuncao = 3")
    suspend fun listRFuncaoIdAtivTipoImplemento(idAtiv: Long, tipoFuncao: Long): List<RFuncaoAtivParadaRoomModel>

}