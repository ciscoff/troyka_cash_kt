package metro.moscow.troykacash.presenter

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import metro.moscow.troykacash.R
import metro.moscow.troykacash.activity.DumpListActivity
import metro.moscow.troykacash.interactor.Interactor
import metro.moscow.troykacash.interactor.ReadyInteractor
import metro.moscow.troykacash.utils.SharedData
import metro.moscow.troykacash.utils.SharedData.Companion.REQUEST_DUMPLIST

class ReadyPresenter(val view: TroykaView, val interactor: ReadyInteractor) : Presenter {

    /**
     * TODO:Сформировать массив строк для названия пунктов выпадающего меню
     */
    override fun getMenuItems(): Array<String> {
        return interactor.getMenuItems()
    }

    /**
     * TODO: Обработка выбора меню. Пункты выпадающего меню - это номера карт
     */
    override fun onMenuSelected(item: String) {

        // Есть ли такая карта в списке карт ?
        val cardId = getMenuItems().toList().find { it == item }

        if(cardId != null) {
            view.startActivity(R.string.card_id, cardId, REQUEST_DUMPLIST, DumpListActivity::class.java)
        }
    }

    /**
     * TODO: Обработка результата работы дочернего активити
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        when(requestCode) {
            REQUEST_DUMPLIST -> {
                dumpSelected(data)
            }
        }
        return
    }

    /**
     * TODO: Обработать выбранный дамп
     */
    private fun dumpSelected(intent: Intent?) {
        val context = view.getContext()

        val fileName = intent?.getStringExtra(context.getString(R.string.dump_file))
        val cardId = intent?.getStringExtra(context.getString(R.string.card_id))
        Toast.makeText(context, "Dump file is: $fileName\ncardId is: $cardId", Toast.LENGTH_LONG).show()
    }
}