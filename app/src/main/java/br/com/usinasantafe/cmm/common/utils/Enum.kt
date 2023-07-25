package br.com.usinasantafe.cmm.common.utils

enum class StatusData { INICIADO, ABERTO, FECHADO }
enum class StatusConnection { OFFLINE, ONLINE }
enum class TypeNote { FALHA, TRABALHANDO, PARADA }
enum class FlowNote { BOLETIM, APONTAMENTO }
enum class StatusSend { VAZIO, ENVIADO, ENVIANDO, ENVIAR }
enum class StatusUpdate { ATUALIZADO, FALHA }
enum class StatusRecover { SUCESSO, VAZIO, FALHA }
enum class PointerStart { MENUINICIAL, MENUAPONT }
enum class FlagUpdateApp { DESATUALIZADO, ATUALIZADO }
enum class FlagUpdateCheckList  { DESATUALIZADO, ATUALIZADO }
enum class ChoiceHorimetro { FALHA, APONTAMENTO, CHECKLIST, IMPLEMENTO }
enum class ChoiceCheckList { CONFORME, ANALISAR, REPARO }
enum class TypeImplemento { TRANSBORDO }