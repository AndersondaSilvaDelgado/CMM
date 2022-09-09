package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.ServicoModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.ServicoDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ServicoDatasourceDB
import javax.inject.Inject

class ServicoDatasourceDBImpl @Inject constructor(
    private val servicoDao: ServicoDao
): ServicoDatasourceDB {

    override suspend fun addServico(servicoModel: ServicoModel): Long {
        return servicoDao.insert(servicoModel)
    }

    override suspend fun deleteAllServico() {
        servicoDao.deleteAll()
    }

}