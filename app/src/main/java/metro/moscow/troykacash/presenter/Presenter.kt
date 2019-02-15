package metro.moscow.troykacash.presenter

import android.content.Intent
import metro.moscow.troykacash.utils.SharedData
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

    /**
     * Методы жизненного цикла
     */
    fun onStart() {
        return
    }

    fun onStop() {
        return
    }

    /**
     *
     */
    fun getMenuItems(): Array<String> {
        return arrayOf("")
    }

    /**
     *
     */
    fun onMenuSelected(item: String) {
        return
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        return
    }

}