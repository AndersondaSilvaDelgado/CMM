package br.com.usinasantafe.cmm.features.external.memory

import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontFert
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimFert
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM

object AppDatabaseMemory{
    var boletimMM: BoletimMM? = null
    var boletimFert: BoletimFert? = null
    var apontMM: ApontMM? = null
    var apontFert: ApontFert? = null
}