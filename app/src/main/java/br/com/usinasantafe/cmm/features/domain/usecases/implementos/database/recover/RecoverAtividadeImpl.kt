package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.common.utils.TEXT_SUCESS_UPDATE
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverAtividade
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverROSAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateAtividade
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateRFuncaoAtivParada
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverAtividadeImpl @Inject constructor(
    private val apontMMFertRepository: ApontMMFertRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val equipRepository: EquipRepository,
    private val recoverREquipAtiv: RecoverREquipAtiv,
    private val recoverROSAtiv: RecoverROSAtiv,
    private val updateAtividade: UpdateAtividade,
    private val updateRFuncaoAtivParada: UpdateRFuncaoAtivParada
): RecoverAtividade {

    override suspend fun invoke(flowNote: FlowNote, contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contRecoverAtiv = contador
            var nroEquip = equipRepository.getEquip().nroEquip
            var nroOS = if(flowNote == FlowNote.BOLETIM) boletimMMFertRepository.getNroOSBoletimAberto() else apontMMFertRepository.getNroOS()
            recoverREquipAtiv(nroEquip.toString(), contRecoverAtiv, qtde).collect{
                emit(it)
                contRecoverAtiv = it.count;
            }
            recoverROSAtiv(nroOS.toString(), contRecoverAtiv, qtde).collect{
                emit(it)
                contRecoverAtiv = it.count;
            }
            updateAtividade(contRecoverAtiv, qtde).collect{
                emit(it)
                contRecoverAtiv = it.count;
            }
            updateRFuncaoAtivParada(contRecoverAtiv, qtde).collect{
                emit(it)
                contRecoverAtiv = it.count;
            }
            emit(ResultUpdateDatabase(count = qtde, describe = TEXT_SUCESS_UPDATE, size = qtde))
        }
    }

}