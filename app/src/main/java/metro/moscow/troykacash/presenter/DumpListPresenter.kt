package metro.moscow.troykacash.presenter

import android.os.Environment
import metro.moscow.troykacash.utils.SharedData
import java.io.File

class DumpListPresenter(val view: TroykaView, val presenter: Presenter?): Presenter {

    /**
     * TODO: Get app files directory
     */
    override fun getAppDir(): File? {
        return Environment.getExternalStorageDirectory()
    }

    /**
     * TODO: Get file list from dir directory
     */
    override fun fileList(dir: File): Array<File>? {
        return SharedData.dumpItems.toList().map{ File(it) }.toTypedArray()
    }
}