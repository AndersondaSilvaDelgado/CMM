package br.com.usinasantafe.cmm.features.domain.usecases.implementos.config

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SaveConfig
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateEquip
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveConfigImpl @Inject constructor(
    private val updateEquip: UpdateEquip,
    private val configRepository: ConfigRepository
): SaveConfig {

    override suspend fun invoke(nroEquip: String, senha: String): Flow<ResultUpdateDataBase> {
        return flow {
            updateEquip(nroEquip).collect{
                emit(it)
                if(it.describe == "Termino de Atualização"){
                    configRepository.saveConfig(nroEquip, senha)
                    emit(ResultUpdateDataBase(100, "Termino de Salvamento de Configurações", 100))
                }
            }
        }
    }

}