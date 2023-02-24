package br.com.usinasantafe.cmm.common.utils

enum class StatusData { INICIADO, ABERTO, FECHADO }
enum class StatusConnection { OFFLINE, ONLINE }
enum class TypeNote { FALHA, TRABALHANDO, PARADA }
enum class FlowNote { BOLETIM, APONTAMENTO }
enum class StatusSend { VAZIO, ENVIADO, ENVIANDO, ENVIAR }
enum class StatusUpdate { ATUALIZADO, FALHA }
enum class StatusRecover { SUCESSO, VAZIO, FALHA }
enum class PointerStart { MENUINICIAL, MENUAPONT }