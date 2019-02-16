package metro.moscow.troykacash.presenter

import android.os.Environment
import metro.moscow.troykacash.interactor.DumpListInteractor
import metro.moscow.troykacash.interactor.Interactor
import metro.moscow.troykacash.utils.SharedData
import java.io.File

class DumpListPresenter(val view: TroykaView, val interactor: DumpListInteractor): Presenter {

    /**
     * TODO: Получить список дампов для карты cardId
     */
    fun getDumpList(cardId: String): Array<String> {
        return interactor.getDumpList(cardId)
    }
}