package metro.moscow.troykacash.interactor

import metro.moscow.troykacash.repository.DumpRepositoryImpl

class DumpListInteractor(val dumpRepo: DumpRepositoryImpl): Interactor {

    /**
     * TODO: Получить список дампов
     */
    fun getDumpList(cardId: String): Array<String> {
        return dumpRepo.getDumpList(cardId)
    }
}