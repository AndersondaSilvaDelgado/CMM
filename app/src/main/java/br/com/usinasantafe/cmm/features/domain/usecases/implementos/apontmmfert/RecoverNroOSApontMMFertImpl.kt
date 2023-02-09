package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.RecoverNroOSApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetNroOSApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverOS
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverNroOSApontMMFertImpl @Inject constructor(
    private val recoverOS: RecoverOS,
    private val setNroOSApontMMFert: SetNroOSApontMMFert
): RecoverNroOSApontMMFert {

    override suspend fun invoke(nroOS: String): Flow<ResultUpdateDataBase> {
        return flow {
            recoverOS(nroOS)
                .collect{
                    emit(it)
                    if(it.describe == "Termino de Atualização"){
                        setNroOSApontMMFert(nroOS)
                        emit(ResultUpdateDataBase(100, "Termino de Salvamento de Configurações", 100))
                    }
                }
        }
    }


}