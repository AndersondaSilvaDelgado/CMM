package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.external.room.dao.variable.BoletimFertDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimFertRoomModel
import javax.inject.Inject

class BoletimFertDatasourceRoomImpl @Inject constructor (
    private val boletimFertDao: BoletimFertDao
): BoletimFertDatasourceRoom {

    override suspend fun checkBoletimAbertoFert(): Boolean {
        return false
    }

    override suspend fun getBoletimAbertoFert(): BoletimFertRoomModel {
        return boletimFertDao.getBoletim(StatusData.ABERTO.ordinal.toLong())
    }

    override suspend fun insertBoletimFert(boletimFertRoomModel: BoletimFertRoomModel): Boolean {
        return boletimFertDao.insert(boletimFertRoomModel) > 0
    }

}