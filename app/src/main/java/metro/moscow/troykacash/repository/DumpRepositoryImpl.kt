package metro.moscow.troykacash.repository

import metro.moscow.troykacash.dao.FileHelper

class DumpRepositoryImpl (val fileHelper: FileHelper): DumpRepository {

    /**
     * TODO: Получить список сохраненных карт
     */
    override fun getCardList() : Array<String> {
        return fileHelper.listDirs()
    }

    /**
     * TODO: Получить список дампов для карты
     */
    override fun getDumpList(cardId: String): Array<String> {
        return fileHelper.listFiles(cardId)
    }
}