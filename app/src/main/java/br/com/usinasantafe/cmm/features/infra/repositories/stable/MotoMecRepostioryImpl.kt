package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.MotoMec
import br.com.usinasantafe.cmm.features.infra.models.toMotoMec
import br.com.usinasantafe.cmm.features.infra.models.toMotoMecModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.MotoMecRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.MotoMecDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.MotoMecDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MotoMecRepostioryImpl @Inject constructor(
    private val motoMecDatasourceRoom: MotoMecDatasourceRoom,
    private val motoMecDatasourceWebService: MotoMecDatasourceWebService
): MotoMecRepository {

    override suspend fun addAllMotoMec(motoMecList: List<MotoMec>) {
        for(motoMec in motoMecList){
            val motoMecModel = motoMec.toMotoMecModel()
            motoMecDatasourceRoom.addMotoMec(motoMecModel)
        }
    }

    override suspend fun deleteAllMotoMec() {
        motoMecDatasourceRoom.deleteAllMotoMec()
    }

    override suspend fun getAllMotoMec(): Flow<Result<List<MotoMec>>> {
        return flow {
            motoMecDatasourceWebService.getAllMotoMec()
                .collect { result ->
                    result.onSuccess {motoMecModelList ->
                        val motoMecList = mutableListOf<MotoMec>()
                        for (motoMecModel in motoMecModelList){
                            motoMecList.add(motoMecModel.toMotoMec())
                        }
                        emit(Result.success(motoMecList))
                    }
                }
        }
    }

}