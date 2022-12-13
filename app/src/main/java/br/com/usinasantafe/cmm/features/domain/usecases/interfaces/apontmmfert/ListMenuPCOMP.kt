package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert

interface ListMenuPCOMP {

    suspend operator fun invoke(): List<String>

}