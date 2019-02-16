package metro.moscow.troykacash.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import metro.moscow.troykacash.R
import metro.moscow.troykacash.TroykaCashApp
import metro.moscow.troykacash.dao.FileHelper
import metro.moscow.troykacash.interactor.DumpListInteractor
import metro.moscow.troykacash.interactor.ReadyInteractor
import metro.moscow.troykacash.presenter.DumpListPresenter
import metro.moscow.troykacash.presenter.Presenter
import metro.moscow.troykacash.presenter.ReadyPresenter
import metro.moscow.troykacash.presenter.TroykaView
import metro.moscow.troykacash.repository.DumpRepositoryImpl
import java.io.File

/**
 * TODO: Эта активити появляется для показа дампов одной уже
 * TODO: выбранной карты. Поэтому нужно просто показать дампы
 * TODO: списком и обработать выбор дампа, вернув его имя.
 */
class DumpListActivity: AppCompatActivity(), TroykaView {
    /**
     * Presenter for current activity
     */
    val presenter: DumpListPresenter = createPresenter()

    /**
     * @savedInstanceState через extra получает cardId выбранной карты
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dumplist)

        // Элемент TextView (для отладки, потом удалить)
//        val textView = findViewById<TextView>(R.id.dumpFile)

        // Элемент ListView
        val lvDumps = findViewById<ListView>(R.id.lvDumps)
        // Номер карты, переданный через intent
        val cardId = intent.getStringExtra(getString(R.string.card_id))

        // Список файлов в каталоге cardId
        val dumps = presenter.getDumpList(cardId)

        // Адаптер к массиву строк с именами файлов
        val adapter = ArrayAdapter<String>(this, R.layout.item_dumplist, dumps)
        // Подключить ListView к данным
        lvDumps.adapter = adapter

        // Как легко и просто вставляется функция :)
        lvDumps.setOnItemClickListener {parent, view, position, id ->
            val dumpName = (view as android.widget.TextView).text
            val intent = Intent()
            intent.putExtra(getString(R.string.card_id), cardId)
            intent.putExtra(getString(R.string.dump_file), dumpName)
            setResult(-1, intent)
            finish()
        }
    }

    /**
     * TODO: Создать презентер, нацеленный на нужную репозиторию
     */
    private fun createPresenter(): DumpListPresenter {
        val fileHelper = (getContext() as TroykaCashApp).fileHelper
        val dumpRepo = DumpRepositoryImpl(fileHelper)
        val interactor = DumpListInteractor(dumpRepo)
        return DumpListPresenter(this, interactor)
    }
}

