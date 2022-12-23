package br.com.usinasantafe.cmm.features.infra.models.variable.webservice

import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontFert
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class ApontFertWebServiceModel(
    var idApontFert: Long,
    var idBolApontFert: Long,
    var nroOSApontFert: Long,
    var idAtivApontFert: Long,
    var idParadaApontFert: Long?,
    var pressaoApontFert: Double,
    var velocApontFert: Long,
    var bocalApontFert: Long,
    var dthrApontFert: String,
    var statusConApontFert: Long,
    var longitudeApontFert: Double,
    var latitudeApontFert: Double,
)


fun ApontFert.toApontFertWebServiceModel(): ApontFertWebServiceModel {
    return with(this){
        ApontFertWebServiceModel(
            idApontFert = this.idApont!!,
            idBolApontFert = this.idBolApont,
            nroOSApontFert =  this.nroOSApont!!,
            idAtivApontFert =  this.idAtivApont!!,
            idParadaApontFert = this.idParadaApont,
            dthrApontFert = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR")).format(this.dthrApont),
            statusConApontFert = this.statusConApont!!.ordinal.toLong(),
            longitudeApontFert = this.longitudeApont!!,
            latitudeApontFert = this.latitudeApont!!,
            pressaoApontFert = this.pressaoApont!!,
            velocApontFert = this.velocApont!!,
            bocalApontFert = this.bocalApont!!
        )
    }
}
