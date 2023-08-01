package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.common.utils.dateNow
import br.com.usinasantafe.cmm.features.domain.entities.variable.CabecCheckList
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.CabecCheckListRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.CabecCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.RespItemCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.CheckListDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.room.variable.toCabecCheckList
import br.com.usinasantafe.cmm.features.infra.models.room.variable.toCabecCheckListRoomModel
import br.com.usinasantafe.cmm.features.infra.models.room.variable.toRespItemCheckList
import br.com.usinasantafe.cmm.features.infra.models.webservice.toBoletimMM
import br.com.usinasantafe.cmm.features.infra.models.webservice.toBoletimMMWebServiceModel
import br.com.usinasantafe.cmm.features.infra.models.webservice.toCabecCheckList
import br.com.usinasantafe.cmm.features.infra.models.webservice.toCabecCheckListWebServiceModel
import javax.inject.Inject

class CabecCheckListRepositoryImpl @Inject constructor(
    private val configRepository: ConfigRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val cabecCheckListDatasourceRoom: CabecCheckListDatasourceRoom,
    private val checkListDatasourceWebService: CheckListDatasourceWebService,
    private val respItemCheckListDatasourceRoom: RespItemCheckListDatasourceRoom
): CabecCheckListRepository {

    override suspend fun closeCabecCheckList(): Boolean {
        return cabecCheckListDatasourceRoom.closeCabecCheckList(cabecCheckListDatasourceRoom.getCabecCheckListOpen())
    }

    override suspend fun getIdCabecCheckListAberto(): Long {
        return cabecCheckListDatasourceRoom.getCabecCheckListOpen().idCabecCheckList!!
    }

    override suspend fun openCabecCheckList(): Boolean {
        val configRepository = configRepository.getConfig()
        var cabecCheckList = CabecCheckList(
            nroEquipCabecCheckList = configRepository.nroEquipConfig!!,
            dtCabecCheckList = dateNow(),
            matricFuncCabecCheckList = boletimMMFertRepository.getNroMatricFuncBoletimAberto(),
            idTurnoCabecCheckList = boletimMMFertRepository.getIdTurnoBoletimAberto()
        )
        return cabecCheckListDatasourceRoom.insertCabecCheckList(cabecCheckList.toCabecCheckListRoomModel())
    }

    override suspend fun receiverSentCabecCheckList(cabecCheckListList: List<CabecCheckList>) {
        cabecCheckListList.forEach { cabecCheckList ->
            cabecCheckListDatasourceRoom.setStatusSent(cabecCheckList.idCabecCheckList!!)
        }
    }

    override suspend fun sendCheckList(): Result<List<CabecCheckList>> {
        var listCabec: List<CabecCheckList> = cabecCheckListDatasourceRoom.listCabecCheckListSend().map { cabecCheckListRoomModel ->
            var cabecCheckList = cabecCheckListRoomModel.toCabecCheckList()
            cabecCheckList.respItemList = respItemCheckListDatasourceRoom.listRespItemCheckListIdCabec(cabecCheckList.idCabecCheckList!!).map { it.toRespItemCheckList() }
            cabecCheckList
        }
        var result = checkListDatasourceWebService.sendCheckList(listCabec.map { it.toCabecCheckListWebServiceModel() })
        return result.map { cabecCheckList -> cabecCheckList.map { it.toCabecCheckList() }}
    }

}