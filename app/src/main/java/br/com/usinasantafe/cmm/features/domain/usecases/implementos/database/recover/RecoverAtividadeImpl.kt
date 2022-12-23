package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverAtividade
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverROSAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateAtividade
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateRFuncaoAtivParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
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

    override suspend fun invoke(flowNote: FlowNote, contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contRecoverAtiv = contador
            var nroEquip = equipRepository.getEquip().nroEquip
            var nroOS = if(flowNote == FlowNote.BOLETIM) boletimMMFertRepository.getOS() else apontMMFertRepository.getOS()
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
            emit(ResultUpdateDataBase(count = qtde, describe = "Atualização realizada com Sucesso!", size = qtde))
        }
    }

}