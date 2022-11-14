package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import android.util.Log
import br.com.usinasantafe.cmm.common.extension.percentage
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.*
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateDataBaseImpl @Inject constructor(
    private val updateAtividade: UpdateAtividade,
    private val updateBocal: UpdateBocal,
    private val updateComponente: UpdateComponente,
    private val updateEquipSeg: UpdateEquipSeg,
    private val updateFrente: UpdateFrente,
    private val updateFunc: UpdateFunc,
    private val updateItemCheckList: UpdateItemCheckList,
    private val updateItemOSMecan: UpdateItemOSMecan,
    private val updateLeira: UpdateLeira,
    private val updateMotoMec: UpdateMotoMec,
    private val updateOS: UpdateOS,
    private val updateParada: UpdateParada,
    private val updatePneu: UpdatePneu,
    private val updatePressaoBocal: UpdatePressaoBocal,
    private val updateProduto: UpdateProduto,
    private val updatePropriedade: UpdatePropriedade,
    private val updateRAtivParada: UpdateRAtivParada,
    private val updateRFuncaoAtivParada: UpdateRFuncaoAtivParada,
    private val updateROSAtiv: UpdateROSAtiv,
    private val updateServico: UpdateServico,
    private val updateTurno: UpdateTurno
) : UpdateDataBase {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var count = count
            val size = 61
            updateAtividade(count).collect{
                it.size = size
                emit(it)
                count = it.count;
                Log.i("CMM", "Atividade Count = ${it.count} --- Size = ${it.size} -- ${it.describe}")
            }
            Log.i("CMM", "Count = $count --- Size = $size")
            updateBocal(count).collect{
                it.size = size
                emit(it)
                count = it.count;
                Log.i("CMM", "Bocal Count = ${it.count} --- Size = ${it.size} -- ${it.describe}")
            }
            Log.i("CMM", "Count = $count --- Size = $size")
            updateComponente(count).collect{
                it.size = size
                emit(it)
                count = it.count;
                Log.i("CMM", "Componente Count = ${it.count} --- Size = ${it.size} -- ${it.describe}")
            }
            Log.i("CMM", "Count = $count --- Size = $size")
            updateEquipSeg(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            Log.i("CMM", "Count = $count --- Size = $size")
            updateFrente(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            Log.i("CMM", "Count = $count --- Size = $size")
            updateFunc(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateItemCheckList(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateItemOSMecan(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateLeira(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateMotoMec(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateOS(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateParada(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updatePneu(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updatePressaoBocal(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateProduto(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updatePropriedade(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateRAtivParada(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateRFuncaoAtivParada(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateROSAtiv(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateServico(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            updateTurno(count).collect{
                it.size = size
                emit(it)
                count = it.count;
            }
            emit(ResultUpdateDataBase(size, "Atualização realizada com Sucesso!", size))
        }
    }

}