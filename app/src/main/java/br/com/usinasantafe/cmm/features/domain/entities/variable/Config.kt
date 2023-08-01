package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.FlagUpdateApp
import br.com.usinasantafe.cmm.common.utils.FlagUpdateCheckList
import br.com.usinasantafe.cmm.common.utils.StatusSend
import java.util.*

data class Config(
    val nroEquipConfig: Long? = null,
    val passwordConfig: String? = null,
    var statusEnvio: StatusSend? = null,
    var idCheckList: Long? = null,
    var versionCurrent: Double? = null,
    var flagUpdateApp: FlagUpdateApp? = null,
    var flagUpdateCheckList: FlagUpdateCheckList? = null,
    var dthrServer: Date? = null,
    var ultTurnoCheckList: Long? = null,
    var dtUltCheckList: Date? = null,
)