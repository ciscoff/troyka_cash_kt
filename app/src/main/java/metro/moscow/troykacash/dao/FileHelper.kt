/**
 * Materials:
 * http://java-help.ru/singleton-in-kotlin/
 */

package metro.moscow.troykacash.dao

import java.io.File
import java.io.FileFilter
import android.os.Environment
import metro.moscow.troykacash.utils.Utils.logI
import metro.moscow.troykacash.utils.SharedData.Companion.APP_ID

/**
 * Класс для работы с файловой системой. Реализуется как Singleton
 */
class FileHelper private constructor() {
    private object FileHolder {
        val INSTANCE = FileHelper()
    }

    // Статические переменные класса
    companion object {
        val instance: FileHelper by lazy { FileHolder.INSTANCE }
    }

    /**
     * Определяем корневой каталог приложения.
     * Как говорится вот здесь:
     * https://stackoverflow.com/questions/15501355/getexternalstoragedirectory-not-working
     * после версии 4.2 для каждого юзера ввели свой external storage. Из этой программы
     * я получаю /storage/emulated/0/ на эмуляторе с API 27 и не могу через adb записать
     * в папку 0 данные. Поэтому для тестирования проги на эмуляторах разных версий я
     * сделал эту проверку.
     */
    val rootDir = if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.JELLY_BEAN) {
        File(File("/sdcard"), APP_ID);
    } else {
        File(Environment.getExternalStorageDirectory(), APP_ID);
    }

    init {
        logI("${android.os.Build.VERSION.SDK_INT}: ${rootDir.absolutePath}")
        if (!rootDir.exists()) {
            rootDir.mkdir();
            logI("$rootDir created")
        }
    }

    /**
     * TODO: Список файлов в каталоге dir
     */
    fun listFiles(dir: String): Array<String> {
        val cardDir = File(rootDir, dir);
        return cardDir.listFiles(FileFilter { f -> f.isFile }).map { f -> f.name }.toTypedArray()
    }

    /**
     * TODO: Список подкаталогов в каталоге dir
     */
    fun listDirs(): Array<String> {
        return rootDir.listFiles(FileFilter { f -> f.isDirectory }).map { f -> f.name }.toTypedArray()
    }

    fun listDirs(dir: String): Array<String> {
        val cardDir = File(rootDir, dir);
        return cardDir.listFiles(FileFilter { f -> f.isDirectory }).map { f -> f.name }.toTypedArray()
    }

}