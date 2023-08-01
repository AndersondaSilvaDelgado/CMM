package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.features.domain.entities.stable.Parada
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ParadaRepository
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.ListParada
import javax.inject.Inject

class ListParadaImpl @Inject constructor(
    private val apontMMFertRepository: ApontMMFertRepository,
    private val rAtivParadaRepository: RAtivParadaRepository,
    private val paradaRepository: ParadaRepository
): ListParada {

    override suspend fun invoke(): List<Parada> {
        var idAtiv = apontMMFertRepository.getIdAtivApontMMFert()
        var listRAtivParada = rAtivParadaRepository.listRAtivParada(idAtiv)
        var listIdParada = listRAtivParada.map { it.idParada }
        return paradaRepository.listInIdParada(listIdParada)
    }
}