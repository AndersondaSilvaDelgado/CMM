package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.common.utils.ChoiceCheckList
import br.com.usinasantafe.cmm.features.domain.entities.variable.RespItemCheckList
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.CabecCheckListRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.RespItemCheckListRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ItemCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.RespItemCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toItemCheckList
import br.com.usinasantafe.cmm.features.infra.models.room.variable.toRespItemCheckListRoomModel
import javax.inject.Inject

class RespItemCheckListRepositoryImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val cabecCheckListRepository: CabecCheckListRepository,
    private val itemCheckListDatasourceRoom: ItemCheckListDatasourceRoom,
    private val respItemCheckListDatasourceRoom: RespItemCheckListDatasourceRoom
): RespItemCheckListRepository {

    override suspend fun countRespItemCheckListAberto(): Int {
        return respItemCheckListDatasourceRoom.countRespItemCheckList(cabecCheckListRepository.getIdCabecCheckListAberto())
    }

    override suspend fun addRespItemCheckListAberto(choiceCheckList: ChoiceCheckList, position: Int): Boolean {
        var idCabec = cabecCheckListRepository.getIdCabecCheckListAberto()
        var idItem = itemCheckListDatasourceRoom.getItemCheckList(equipRepository.getEquip().idCheckList, position).toItemCheckList().idItemCheckList
        var respItemCheckList = RespItemCheckList(
            idCabecRespItemCheckList = idCabec,
            idItemRespItemCheckList = idItem,
            opcaoRespItemCheckList = choiceCheckList,
        )
        return respItemCheckListDatasourceRoom.insertRespItemCheckList(respItemCheckList.toRespItemCheckListRoomModel())
    }

    override suspend fun deleteRespItemCheckListAberto(position: Int): Boolean {
        var idCabec = cabecCheckListRepository.getIdCabecCheckListAberto()
        var idItem = itemCheckListDatasourceRoom.getItemCheckList(equipRepository.getEquip().idCheckList, position).toItemCheckList().idItemCheckList
        return respItemCheckListDatasourceRoom.deleteRespItemCheckList(idCabec, idItem)
    }

}