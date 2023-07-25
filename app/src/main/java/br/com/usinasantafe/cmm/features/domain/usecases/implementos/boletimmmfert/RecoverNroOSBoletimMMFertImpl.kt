package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.common.utils.TEXT_FINISH_UPDATE
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.RecoverNroOSBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetNroOSBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverOS
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverNroOSBoletimMMFertImpl @Inject constructor(
    private val recoverOS: RecoverOS,
    private val setNroOSBoletimMMFert: SetNroOSBoletimMMFert
): RecoverNroOSBoletimMMFert {

    override suspend fun invoke(nroOS: String, checkConn: Boolean): Flow<ResultUpdateDatabase> {

        return flow {
            recoverOS(nroOS)
                .collect{
                    emit(it)
                    if(it.describe == TEXT_FINISH_UPDATE){
                        setNroOSBoletimMMFert(nroOS)
                        emit(ResultUpdateDatabase(100, "Termino de Salvamento de Configurações", 100))
                    }
                }
        }
    }

}