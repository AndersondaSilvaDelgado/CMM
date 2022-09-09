package br.com.usinasantafe.cmm.features.core.external.remote.util

interface ResponseWeb{

    fun getGeneric(classe: String) : String?

    fun postGeneric(objeto: String, dados: String) : String?

}