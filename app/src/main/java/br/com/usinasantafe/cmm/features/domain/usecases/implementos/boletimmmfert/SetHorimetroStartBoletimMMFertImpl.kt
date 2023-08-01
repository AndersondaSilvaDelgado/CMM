package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.common.utils.ChoiceHorimetro
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.InsertParadaCheckListMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckImplementoBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckOpenCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetHorimetroStartBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.implementommfert.ClearDataImplemento
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartProcessSendData
import javax.inject.Inject

class SetHorimetroStartBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val checkOpenCheckList: CheckOpenCheckList,
    private val checkImplementoBoletimMMFert: CheckImplementoBoletimMMFert,
    private val clearDataImplemento: ClearDataImplemento,
    private val insertParadaCheckListMMFert: InsertParadaCheckListMMFert,
    private val startProcessSendData: StartProcessSendData,
): SetHorimetroStartBoletimMMFert {

    override suspend fun invoke(horimetroInicial: String): ChoiceHorimetro {
        return if(boletimMMFertRepository.setHorimetroInicialBoletimMMFert(horimetroInicial)) {
            if(boletimMMFertRepository.insertBoletimMMFert()){
                if(checkImplementoBoletimMMFert()){
                    clearDataImplemento()
                    ChoiceHorimetro.IMPLEMENTO
                } else {
                    if(checkOpenCheckList()){
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