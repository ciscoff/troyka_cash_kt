/**
 * Materials:
 * http://java-help.ru/singleton-in-kotlin/
 */

package metro.moscow.troykacash.dao

import metro.moscow.troykacash.utils.SharedData

/**
 * Класс для работы с файловой системой. Реализуется как Singleton
 */
class FileHelper private constructor() {
    private object FileHolder {
        val INSTANCE = FileHelper()
    }

    companion object {
        val instance: FileHelper by lazy { FileHolder.INSTANCE }
    }

    /**
     * TODO: Список файлов в каталоге dir
     */
    fun listFiles(dir: String): Array<String> {
        return SharedData.dumpItems
    }

    fun listDirs(): Array<String> {
        return SharedData.cardNums
    }
}