/**
 * Materials:
 * http://java-help.ru/singleton-in-kotlin/
 */

package metro.moscow.troykacash.dao

import android.os.Environment
import metro.moscow.troykacash.utils.SharedData
import java.io.File
import android.util.Log
import metro.moscow.troykacash.utils.SharedData.Companion.APP_DIR
import java.io.FileFilter

/**
 * Класс для работы с файловой системой. Реализуется как Singleton
 */
class FileHelper private constructor() {
    private object FileHolder {
        val INSTANCE = FileHelper()
    }

    // Статические переменные кдасса
    companion object {
        val instance: FileHelper by lazy { FileHolder.INSTANCE }
    }

    // Корневой каталог приложения
    val rootDir = File(Environment.getExternalStorageDirectory(), APP_DIR);

    init {
        if (!rootDir.exists()) {
            rootDir.mkdir();
            Log.d("SYLOG", "$rootDir created")
        }
    }

    /**
     * TODO: Список файлов в каталоге dir
     */
    fun listFiles(dir: String): Array<String> {
        val cardDir = File(rootDir, dir);
        return cardDir.listFiles(FileFilter { f -> f.isFile }).map { f -> f.name }.toTypedArray()
//        return SharedData.dumpItems
    }

    /**
     * TODO: Список подкаталогов в каталоге dir
     */
    fun listDirs(): Array<String> {
        return rootDir.listFiles(FileFilter { f -> f.isDirectory }).map { f -> f.name }.toTypedArray()
        //return SharedData.cardNums
    }

    fun listDirs(dir: String): Array<String> {
        val cardDir = File(rootDir, dir);
        return cardDir.listFiles(FileFilter { f -> f.isDirectory }).map { f -> f.name }.toTypedArray()
        //return SharedData.cardNums
    }


}