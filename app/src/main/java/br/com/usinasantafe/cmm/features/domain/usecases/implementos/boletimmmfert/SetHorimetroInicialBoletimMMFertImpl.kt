package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.common.utils.ChoiceHorimetro
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ImplementoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.InsertParadaCheckListMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckImplementoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckAberturaCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetHorimetroInicialBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartProcessSendData
import javax.inject.Inject

class SetHorimetroInicialBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val checkAberturaCheckList: CheckAberturaCheckList,
    private val checkImplementoBoletimMMFert: CheckImplementoBoletimMMFert,
    private val implementoRepository: ImplementoRepository,
    private val insertParadaCheckListMMFert: InsertParadaCheckListMMFert,
    private val startProcessSendData: StartProcessSendData,
): SetHorimetroInicialBoletimMMFert {

    override suspend fun invoke(horimetroInicial: String): ChoiceHorimetro {
        return if(boletimMMFertRepository.setHorimetroInicialBoletimMMFert(horimetroInicial)) {
            if(boletimMMFertRepository.insertBoletimMMFert()){
                if(checkImplementoBoletimMMFert()){
                    implementoRepository.clearData()
                    ChoiceHorimetro.IMPLEMENTO
                } else {
                    if(checkAberturaCheckList()){
                        if(insertParadaCheckListMMFert()){
                            startProcessSendData()
                        }
                        ChoiceHorimetro.CHECKLIST
                    } else {
                        startProcessSendData()
                        ChoiceHorimetro.APONTAMENTO
                    }
                }
            } else ChoiceHorimetro.FALHA
        } else ChoiceHorimetro.FALHA
    }

}