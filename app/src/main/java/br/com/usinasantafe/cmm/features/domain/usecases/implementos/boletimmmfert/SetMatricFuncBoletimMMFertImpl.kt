package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetMatricFuncBoletimMMFert
import javax.inject.Inject

class SetMatricFuncBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository
): SetMatricFuncBoletimMMFert
{
    override suspend fun invoke(matricOperador: String): Boolean {
        return boletimMMFertRepository.startBoletimMMFert()
    }
}