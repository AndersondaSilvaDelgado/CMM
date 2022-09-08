package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.MotoMecModel

interface MotoMecDatasourceWeb {

    suspend fun getAllMotoMec(): List<MotoMecModel>

}