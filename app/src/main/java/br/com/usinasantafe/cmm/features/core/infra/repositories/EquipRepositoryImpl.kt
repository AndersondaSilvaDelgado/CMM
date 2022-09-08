package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Equip
import br.com.usinasantafe.cmm.features.core.domain.entities.REquipAtiv
import br.com.usinasantafe.cmm.features.core.domain.entities.REquipPneu
import br.com.usinasantafe.cmm.features.core.infra.models.*
import br.com.usinasantafe.cmm.features.core.domain.repositories.EquipRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.EquipDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.REquipAtivDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.REquipPneuDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.EquipDatasourceWeb
import javax.inject.Inject

class EquipRepositoryImpl @Inject constructor(
    private val equipDatasourceWeb: EquipDatasourceWeb,
    private val equipDatasourceDB: EquipDatasourceDB,
    private val rEquipAtivDatasourceDB: REquipAtivDatasourceDB,
    private val rEquipPneuDatasourceDB: REquipPneuDatasourceDB
): EquipRepository {

    override suspend fun addEquip(equip: Equip) {
        val rEquipAtivList = equip.rEquipAtivList
        for (rEquipAtiv in rEquipAtivList){
            rEquipAtivDatasourceDB.addREquipAtiv(rEquipAtiv.toREquipAtivModel())
        }
        val rEquipPneuList = equip.rEquipPneuList
        for (rEquipPneu in rEquipPneuList){
            rEquipPneuDatasourceDB.addREquipPneu(rEquipPneu.toREquipPneuModel())
        }
        equipDatasourceDB.addEquip(equip.toEquipModel())
    }

    override suspend fun deleteAllEquip() {
        equipDatasourceDB.deleteAllEquip()
        rEquipAtivDatasourceDB.deleteAllREquipAtiv()
        rEquipPneuDatasourceDB.deleteAllREquipPneu()
    }

    override suspend fun getEquip(nroEquip: Long): Equip {
        val list = equipDatasourceWeb.getDadosEquip(nroEquip)
        lateinit var equip: Equip
        val rEquipAtivList = mutableListOf<REquipAtiv>()
        val rEquipPneuList = mutableListOf<REquipPneu>()
        for (obj in list) {
            if (obj.javaClass == EquipModel::class.java) {
                val equipModel: EquipModel = obj as EquipModel
                equip = equipModel.toEquip()
            }
            if (obj.javaClass == REquipAtivModel::class.java) {
                val rEquipAtivModel: REquipAtivModel = obj as REquipAtivModel
                rEquipAtivList.add(rEquipAtivModel.toREquipAtiv())
            }
            if (obj.javaClass == REquipPneuModel::class.java) {
                val rEquipAtivModel: REquipPneuModel = obj as REquipPneuModel
                rEquipPneuList.add(rEquipAtivModel.toREquipPneu())
            }
        }
        equip.rEquipAtivList = rEquipAtivList
        equip.rEquipPneuList = rEquipPneuList
        return equip
    }

}