package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database

import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.UpdateAllDataBase
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.*
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateAllDataBaseImpl @Inject constructor(
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
) : UpdateAllDataBase {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            updateAtividade(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateBocal(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateComponente(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateEquipSeg(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateFrente(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateFunc(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateItemCheckList(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateItemOSMecan(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateLeira(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateMotoMec(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateOS(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateParada(count, size).collect{
                emit(it)
                count = it.count;
            }
            updatePneu(count, size).collect{
                emit(it)
                count = it.count;
            }
            updatePressaoBocal(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateProduto(count, size).collect{
                emit(it)
                count = it.count;
            }
            updatePropriedade(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateRAtivParada(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateRFuncaoAtivParada(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateROSAtiv(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateServico(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateTurno(count, size).collect{
                emit(it)
                count = it.count;
            }
            emit(ResultUpdateDataBase(size, "Atualização realizada com Sucesso!", size))
        }
    }

}