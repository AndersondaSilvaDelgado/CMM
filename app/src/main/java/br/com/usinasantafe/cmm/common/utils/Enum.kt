package br.com.usinasantafe.cmm.common.utils

enum class StatusData { INITIATE, OPEN, CLOSE  }
enum class StatusConnection { OFFLINE, ONLINE }
enum class TypeNote { FALHA, TRABALHANDO, PARADA }
enum class FlowNote { BOLETIM, APONTAMENTO }
enum class StatusSend { EMPTY, SENT, SENDING, SEND }
enum class StatusUpdate { ATUALIZADO, FALHA }
enum class StatusRecover { SUCESSO, VAZIO, FALHA }
enum class PointerStart { MENUINICIAL, MENUAPONT, IMPLEMENTO }
enum class FlagUpdateApp { DESATUALIZADO, ATUALIZADO }
enum class FlagUpdateCheckList  { DESATUALIZADO, ATUALIZADO }
enum class ChoiceHorimetro { FALHA, APONTAMENTO, CHECKLIST, IMPLEMENTO }
enum class ChoiceCheckList { CONFORME, NAOCONFORME, REPARO }
enum class StatusImplemento{ OK, INEXISTENTE, REPETIDO }
