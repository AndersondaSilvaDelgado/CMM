package br.com.usinasantafe.cmm.features.core.domain.usecases.implementos

import br.com.usinasantafe.cmm.features.core.domain.entities.Config
import br.com.usinasantafe.cmm.features.core.domain.repositories.ConfigRepository
import br.com.usinasantafe.cmm.features.core.domain.repositories.EquipRepository
import br.com.usinasantafe.cmm.features.core.domain.usecases.interfaces.SalvarDadosConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SalvarDadosConfigImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val configRepository: ConfigRepository
): SalvarDadosConfig {

    override suspend fun invoke(nroEquip: Long, senha: String) {
        configRepository.deleteAllConfig()
        equipRepository.deleteAllEquip()
        val equip = withContext(Dispatchers.Default){
            equipRepository.getEquip(nroEquip)
        }
        equipRepository.addEquip(equip)
        configRepository.addConfig(Config(nroEquip, senha))
    }

}