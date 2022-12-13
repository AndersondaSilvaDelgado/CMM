package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert

interface ListMenuECM {

    suspend operator fun invoke(): List<String>

}