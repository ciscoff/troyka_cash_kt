package metro.moscow.troykacash.interactor

import metro.moscow.troykacash.repository.DumpRepositoryImpl

class ReadyInteractor(val dumpRepo: DumpRepositoryImpl) : Interactor {

    fun getMenuItems(): Array<String> {
        return dumpRepo.getCardList()
    }
}