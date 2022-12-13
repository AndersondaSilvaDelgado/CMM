package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.external.room.dao.BoletimFertDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.BoletimFertDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimFertModel
import javax.inject.Inject

class BoletimFertDatasourceRoomImpl @Inject constructor (
    private val boletimFertDao: BoletimFertDao
): BoletimFertDatasourceRoom {

    override suspend fun getBoletimAbertoFert(): BoletimFertModel {
        return boletimFertDao.getBoletim(StatusData.ABERTO.ordinal.toLong())
    }

    override suspend fun insertBoletimFert(boletimFertModel: BoletimFertModel): Boolean {
        return boletimFertDao.insert(boletimFertModel) > 0
    }

}