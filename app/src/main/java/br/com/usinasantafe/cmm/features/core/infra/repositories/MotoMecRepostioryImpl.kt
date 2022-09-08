package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.MotoMec
import br.com.usinasantafe.cmm.features.core.infra.models.toMotoMec
import br.com.usinasantafe.cmm.features.core.infra.models.toMotoMecModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.MotoMecRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.MotoMecDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.MotoMecDatasourceWeb
import javax.inject.Inject

class MotoMecRepostioryImpl @Inject constructor(
    private val motoMecDatasourceDB: MotoMecDatasourceDB,
    private val motoMecDatasourceWeb: MotoMecDatasourceWeb
): MotoMecRepository {

    override suspend fun addAllMotoMec(motoMecList: List<MotoMec>) {
        for(motoMec in motoMecList){
            val motoMecModel = motoMec.toMotoMecModel()
            motoMecDatasourceDB.addMotoMec(motoMecModel)
        }
    }

    override suspend fun deleteAllMotoMec() {
        motoMecDatasourceDB.deleteAllMotoMec()
    }

    override suspend fun getAllMotoMec(): List<MotoMec> {
        val motoMecModelList = motoMecDatasourceWeb.getAllMotoMec()
        val motoMecList = mutableListOf<MotoMec>()
        for (motoMecModel in motoMecModelList){
            motoMecList.add(motoMecModel.toMotoMec())
        }
        return motoMecList
    }

}