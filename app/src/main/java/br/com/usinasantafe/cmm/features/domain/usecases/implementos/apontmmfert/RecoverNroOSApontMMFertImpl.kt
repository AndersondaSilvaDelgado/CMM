package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.RecoverNroOSApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetNroOSApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverOS
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverNroOSApontMMFertImpl @Inject constructor(
    private val recoverOS: RecoverOS,
    private val setNroOSApontMMFert: SetNroOSApontMMFert
): RecoverNroOSApontMMFert {

    override suspend fun invoke(nroOS: String): Flow<ResultUpdateDatabase> {
        return flow {
            recoverOS(nroOS)
                .collect{
                    emit(it)
                    if(it.describe == "Termino de Atualização"){
                        setNroOSApontMMFert(nroOS)
                        emit(ResultUpdateDatabase(100, "Termino de Salvamento de Configurações", 100))
                    }
                }
        }
    }


}