package br.com.usinasantafe.cmm.features.core.external.remote.util

import br.com.usinasantafe.cmm.common.network.ServiceGeneric
import javax.inject.Inject

class ResponseWebImpl @Inject constructor(
    private val serviceGeneric: ServiceGeneric
): ResponseWeb{

    override fun getGeneric(classe: String): String? {
        return serviceGeneric.getGeneric(classe).execute().body()?.string()
    }

    override fun postGeneric(objeto: String, dados: String): String? {
        return serviceGeneric.postGeneric(objeto, dados).execute().body()?.string()
    }

}