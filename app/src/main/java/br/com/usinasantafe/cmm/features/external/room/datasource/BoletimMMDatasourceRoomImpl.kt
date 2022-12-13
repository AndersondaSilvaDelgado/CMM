package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.external.room.dao.BoletimMMDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.BoletimMMDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.models.variable.room.BoletimMMModel
import javax.inject.Inject

class BoletimMMDatasourceRoomImpl @Inject constructor (
    private val boletimMMDao: BoletimMMDao
): BoletimMMDatasourceRoom {

    override suspend fun getBoletimAbertoMM(): BoletimMMModel {
        return boletimMMDao.getBoletim(StatusData.ABERTO.ordinal.toLong())
    }

    override suspend fun insertBoletimMM(boletimMMModel: BoletimMMModel): Boolean {
        return boletimMMDao.insert(boletimMMModel) > 0
    }

}