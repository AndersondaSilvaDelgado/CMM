package br.com.usinasantafe.cmm.features.infra.models.variable.webservice

import br.com.usinasantafe.cmm.common.utils.FlagUpdateApp
import br.com.usinasantafe.cmm.common.utils.FlagUpdateCheckList
import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class ConfigWebServiceModelOutput(
    val idEquip: Long,
    val versionCurrent: String,
    val idCheckList: Long
)

@Serializable
data class ConfigWebServiceModelInput(
    var flagUpdateApp: Long,
    var flagUpdateCheckList: Long,
    var dthrServer: String,
)

fun Config.toConfigWebServiceModel(): ConfigWebServiceModelOutput {
    return with(this){
        ConfigWebServiceModelOutput(
            idEquip = this.nroEquipConfig!!,
            versionCurrent = this.versionCurrent!!.toString(),
            idCheckList = this.idCheckList!!,
        )
    }
}

fun ConfigWebServiceModelInput.toConfig(): Config {
    return with(this){
        Config(
            flagUpdateApp = FlagUpdateApp.values()[this.flagUpdateApp.toInt()],
            flagUpdateCheckList = FlagUpdateCheckList.values()[this.flagUpdateCheckList.toInt()],
            dthrServer = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR")).parse(this.dthrServer)
        )
    }
}
