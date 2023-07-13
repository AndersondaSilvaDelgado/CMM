package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.common.utils.dateNow
import br.com.usinasantafe.cmm.features.domain.entities.variable.CabecCheckList
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.CabecCheckListRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.CabecCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.room.variable.toCabecCheckListRoomModel
import javax.inject.Inject

class CabecCheckListRepositoryImpl @Inject constructor(
    private val configRepository: ConfigRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val cabecCheckListDatasourceRoom: CabecCheckListDatasourceRoom
): CabecCheckListRepository {

    override suspend fun idCabecCheckListAberto(): Long {
        TODO("Not yet implemented")
    }

    override suspend fun openCabecCheckList() {
        val configRepository = configRepository.getConfig()
        var cabecCheckList = CabecCheckList(
            nroEquipCabecCheckList = configRepository.nroEquipConfig!!,
            dtCabecCheckList = dateNow(),
            matricFuncCabecCheckList = boletimMMFertRepository.getNroMatricFuncBoletimAberto(),
            idTurnoCabecCheckList = boletimMMFertRepository.getIdTurnoBoletimAberto()
        )
        cabecCheckListDatasourceRoom.insertCabecCheckList(cabecCheckList.toCabecCheckListRoomModel())
    }

}