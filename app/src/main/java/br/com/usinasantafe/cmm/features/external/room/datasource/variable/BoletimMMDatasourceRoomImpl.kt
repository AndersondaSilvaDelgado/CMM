package br.com.usinasantafe.cmm.features.external.room.datasource.variable

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.external.room.dao.variable.BoletimMMDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.variable.BoletimMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMRoomModel
import javax.inject.Inject

class BoletimMMDatasourceRoomImpl @Inject constructor (
    private val boletimMMDao: BoletimMMDao
): BoletimMMDatasourceRoom {

    override suspend fun getBoletimAbertoMM(): BoletimMMRoomModel {
        return boletimMMDao.listBoletimStatus(StatusData.ABERTO.ordinal.toLong())[0]
    }

    override suspend fun insertBoletimMM(boletimMMRoomModel: BoletimMMRoomModel): Boolean {
        return boletimMMDao.insert(boletimMMRoomModel) > 0
    }

    override suspend fun listBoletimAbertoMM(): List<BoletimMMRoomModel> {
        return boletimMMDao.listBoletimStatus(StatusData.ABERTO.ordinal.toLong())
    }

}