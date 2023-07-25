package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config

import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow

interface SaveConfig {

    suspend operator fun invoke(nroEquip: String, senha: String): Flow<ResultUpdateDatabase>

}