package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.ListMenuPMM
import javax.inject.Inject

class ListMenuPMMImpl @Inject constructor(
    private val equipRepository: EquipRepository,
    private val rFuncaoAtivParadaRepository: RFuncaoAtivParadaRepository
): ListMenuPMM {

    override suspend fun invoke(): List<String> {
        var listMenu = mutableListOf<String>()
        listMenu.add("TRABALHANDO")
        listMenu.add("PARADO")
        if(equipRepository.getEquip().tipoEquip == 1L){
            val listRFuncaoAtiv = rFuncaoAtivParadaRepository.listRFuncaoAtiv()
            for (rFuncaoAtiv in listRFuncaoAtiv){
                when(rFuncaoAtiv.codFuncao){
                    1L -> listMenu.add("RENDIMENTO")
                    2L -> listMenu.add("NOVO TRANSBORDO")
                    3L -> listMenu.add("TROCAR IMPLEMENTO")
                }
            }
        } else {
            listMenu.add("RECOLHIMENTO MANGUEIRA")
        }
        listMenu.add("FINALIZAR BOLETIM")
        listMenu.add("HISTORICO")
        listMenu.add("REENVIO DE DADOS")
        listMenu.add("DATA/HORA")
        listMenu.add("LOG")
        return listMenu
    }

}