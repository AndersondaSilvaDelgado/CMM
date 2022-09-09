package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.EquipModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.EquipDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.EquipDatasourceDB
import javax.inject.Inject

class EquipDatasourceDBImpl @Inject constructor (
    private val equipDao: EquipDao
): EquipDatasourceDB {

    override suspend fun addEquip(equipModel: EquipModel): Long {
        return equipDao.insert(equipModel)
    }

    override suspend fun deleteAllEquip() {
        equipDao.deleteAll()
    }


}