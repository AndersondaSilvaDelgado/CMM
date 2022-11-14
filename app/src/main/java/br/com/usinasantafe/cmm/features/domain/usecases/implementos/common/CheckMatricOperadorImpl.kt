package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.repositories.stable.FuncRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckMatricOperador
import javax.inject.Inject

class CheckMatricOperadorImpl @Inject constructor (
    private val funcRepository: FuncRepository
): CheckMatricOperador {

    override suspend fun invoke(matricFunc: String): Boolean {
        return funcRepository.checkFuncNro(matricFunc)
    }

}