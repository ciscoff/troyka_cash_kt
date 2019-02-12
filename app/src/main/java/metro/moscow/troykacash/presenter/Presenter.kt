package metro.moscow.troykacash.presenter

import java.io.File

interface Presenter {

    /**
     * Методы для работы с файловой системой
     */
    fun getAppDir(): File? {
        return null
    }
    fun fileList(dir: File): Array<File>? {
        return null
    }

}