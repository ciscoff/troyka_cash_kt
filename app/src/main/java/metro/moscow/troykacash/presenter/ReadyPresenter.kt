package metro.moscow.troykacash.presenter

import metro.moscow.troykacash.R
import metro.moscow.troykacash.activity.DumpListActivity
import metro.moscow.troykacash.utils.SharedData

class ReadyPresenter(val view: TroykaView, val presenter: Presenter?) : Presenter {

    /**
     * TODO:Сформировать массив строк для названия пунктов выпадающего меню
     */
    override fun getMenuItems(): Array<String> {
        return SharedData.menuItems
    }

    /**
     * TODO: Обработка выбора меню. Это номер карты
     */
    override fun onMenuSelected(item: String) {

        // Есть ли такая карта в списке карт ?
        val cardId = getMenuItems().toList().find { it == item }

        if(cardId != null) {
            view.startActivity(R.string.card_id, cardId, DumpListActivity::class.java)
        }
    }
}