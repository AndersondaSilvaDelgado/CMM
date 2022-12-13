package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.stable.ServicoModel
import kotlinx.coroutines.flow.Flow

interface ServicoDatasourceWebService {

    suspend fun getAllServico(): Flow<Result<List<ServicoModel>>>

}