package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.features.domain.entities.variable.Implemento
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ImplementoRepository
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ImplementoDatasourceSharedPreferences
import javax.inject.Inject

class ImplementoRepositoryImpl @Inject constructor (
    private val implementoDatasourceSharedPreferences: ImplementoDatasourceSharedPreferences
): ImplementoRepository {

    override suspend fun addImplemento(nroEquip: Long): Boolean {
        var implemento = Implemento(codEquip = nroEquip, posicao = (countImplemento() + 1).toLong())
        return implementoDatasourceSharedPreferences.addImplemento(implemento)
    }

    override suspend fun clearData() {
        implementoDatasourceSharedPreferences.clearData()
    }

    override suspend fun countImplemento(): Int {
        return implementoDatasourceSharedPreferences.countImplemento()
    }

    override suspend fun listImplemento(): List<Implemento> {
        return implementoDatasourceSharedPreferences.listImplemento()
    }
}