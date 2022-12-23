package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert

import br.com.usinasantafe.cmm.common.utils.TypeNote

interface SetIdAtivApontMMFert {

    suspend operator fun invoke(idAtiv: Long): TypeNote

}