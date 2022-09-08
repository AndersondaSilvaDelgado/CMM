package br.com.usinasantafe.cmm.features.core.domain.usecases.implementos

import android.util.Log
import br.com.usinasantafe.cmm.features.core.domain.repositories.*
import br.com.usinasantafe.cmm.features.core.domain.usecases.interfaces.UpdateDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateDataBaseImpl @Inject constructor(
    private val atividadeRepository : AtividadeRepository,
    private val bocalRepository: BocalRepository,
    private val componenteRepository: ComponenteRepository,
    private val equipSegRepository: EquipSegRepository,
    private val frenteRepository: FrenteRepository,
    private val funcRepository: FuncRepository,
    private val itemCheckListRepository: ItemCheckListRepository,
    private val itemOSMecanRepository: ItemOSMecanRepository,
    private val leiraRepository: LeiraRepository,
    private val motoMecRepository: MotoMecRepository,
    private val osRepository: OSRepository,
    private val paradaRepository: ParadaRepository,
    private val pneuRepository: PneuRepository,
    private val pressaoBocalRepository: PressaoBocalRepository,
    private val produtoRepository: ProdutoRepository,
    private val propriedadeRepository: PropriedadeRepository,
    private val rAtivParadaRepository: RAtivParadaRepository,
    private val rFuncaoAtivParadaRepository: RFuncaoAtivParadaRepository,
    private val rOSAtivRepository: ROSAtivRepository,
    private val servicoRepository: ServicoRepository,
    private val turnoRepository: TurnoRepository
) : UpdateDataBase {

    override suspend fun updateAtividade() {
        atividadeRepository.deleteAllAtividade()
        val ativList = withContext(Dispatchers.Default){
            atividadeRepository.getAllAtividade()
        }
        atividadeRepository.addAllAtividade(ativList)
    }

    override suspend fun updateBocal() {
        bocalRepository.deleteAllBocal()
        val bocalList = withContext(Dispatchers.Default){
            bocalRepository.getAllBocal()
        }
        bocalRepository.addAllBocal(bocalList)
    }

    override suspend fun updateComponente() {
        componenteRepository.deleteAllComponente()
        val componenteList = withContext(Dispatchers.Default){
            componenteRepository.getAllComponente()
        }
        componenteRepository.addAllComponente(componenteList)
    }

    override suspend fun updateEquipSeg() {
        equipSegRepository.deleteAllEquipSeg()
        val equipSegList = withContext(Dispatchers.Default){
            equipSegRepository.getAllEquipSeg()
        }
        equipSegRepository.addAllEquipSeg(equipSegList)
    }

    override suspend fun updateFrente() {
        frenteRepository.deleteAllFrente()
        val frenteList = withContext(Dispatchers.Default){
            frenteRepository.getAllFrente()
        }
        frenteRepository.addAllFrente(frenteList)
    }

    override suspend fun updateFunc() {
        funcRepository.deleteAllFunc()
        val funcList = withContext(Dispatchers.Default){
            funcRepository.getAllFunc()
        }
        funcRepository.addAllFunc(funcList)
    }

    override suspend fun updateItemCheckList() {
        itemCheckListRepository.deleteAllItemCheckList()
        val itemCheckListList = withContext(Dispatchers.Default){
            itemCheckListRepository.getAllItemCheckList()
        }
        itemCheckListRepository.addAllItemCheckList(itemCheckListList)
    }

    override suspend fun updateItemOSMecan() {
        itemOSMecanRepository.deleteAllItemOSMecan()
        val itemOSMecan = withContext(Dispatchers.Default){
            itemOSMecanRepository.getAllItemOSMecan()
        }
        itemOSMecanRepository.addAllItemOSMecan(itemOSMecan)
    }

    override suspend fun updateLeira() {
        leiraRepository.deleteAllLeira()
        val leiraList = withContext(Dispatchers.Default){
            leiraRepository.getAllLeira()
        }
        leiraRepository.addAllLeira(leiraList)
    }

    override suspend fun updateMotoMec() {
        motoMecRepository.deleteAllMotoMec()
        val motoMecList = withContext(Dispatchers.Default){
            motoMecRepository.getAllMotoMec()
        }
        motoMecRepository.addAllMotoMec(motoMecList)
    }

    override suspend fun updateOS() {
        osRepository.deleteAllOS()
        val osList = withContext(Dispatchers.Default){
            osRepository.getAllOS()
        }
        osRepository.addAllOS(osList)
    }

    override suspend fun updateParada() {
        paradaRepository.deleteAllParada()
        val paradaList = withContext(Dispatchers.Default){
            paradaRepository.getAllParada()
        }
        paradaRepository.addAllParada(paradaList)
    }

    override suspend fun updatePneu() {
        pneuRepository.deleteAllPneu()
        val pneuList = withContext(Dispatchers.Default){
            pneuRepository.getAllPneu()
        }
        pneuRepository.addAllPneu(pneuList)
    }

    override suspend fun updatePressaoBocal() {
        pressaoBocalRepository.deleteAllPressaoBocal()
        val pressaoBocalList = withContext(Dispatchers.Default){
            pressaoBocalRepository.getAllPressaoBocal()
        }
        pressaoBocalRepository.addAllPressaoBocal(pressaoBocalList)
    }

    override suspend fun updateProduto() {
        produtoRepository.deleteAllProduto()
        val produtoList = withContext(Dispatchers.Default){
            produtoRepository.getAllProduto()
        }
        produtoRepository.addAllProduto(produtoList)
    }

    override suspend fun updatePropriedade() {
        propriedadeRepository.deleteAllPropriedade()
        val propriedadeList = withContext(Dispatchers.Default){
            propriedadeRepository.getAllPropriedade()
        }
        propriedadeRepository.addAllPropriedade(propriedadeList)
    }

    override suspend fun updateRAtivParada() {
        rAtivParadaRepository.deleteAllRAtivParada()
        val rAtivParadaList = withContext(Dispatchers.Default){
            rAtivParadaRepository.getAllRAtivParada()
        }
        rAtivParadaRepository.addAllRAtivParada(rAtivParadaList)
    }

    override suspend fun updateRFuncaoAtivParada() {
        rFuncaoAtivParadaRepository.deleteAllRFuncaoAtivParada()
        val rFuncaoAtivParadaList = withContext(Dispatchers.Default){
            rFuncaoAtivParadaRepository.getAllRFuncaoAtivParada()
        }
        rFuncaoAtivParadaRepository.addAllRFuncaoAtivParada(rFuncaoAtivParadaList)
    }

    override suspend fun updateROSAtiv() {
        rOSAtivRepository.deleteAllROSAtiv()
        val rOSAtivList = withContext(Dispatchers.Default){
            rOSAtivRepository.getAllROSAtiv()
        }
        rOSAtivRepository.addAllROSAtiv(rOSAtivList)
    }

    override suspend fun updateServico() {
        servicoRepository.deleteAllServico()
        val servicoList = withContext(Dispatchers.Default){
            servicoRepository.getAllServico()
        }
        servicoRepository.addAllServico(servicoList)
    }

    override suspend fun updateTurnoParada() {
        turnoRepository.deleteAllTurno()
        val turnoList = withContext(Dispatchers.Default){
            turnoRepository.getAllTurno()
        }
        turnoRepository.addAllTurno(turnoList)
    }

}