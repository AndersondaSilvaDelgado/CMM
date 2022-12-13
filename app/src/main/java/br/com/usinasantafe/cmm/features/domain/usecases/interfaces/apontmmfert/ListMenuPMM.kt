package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert

interface ListMenuPMM {

    suspend operator fun invoke(): List<String>

}