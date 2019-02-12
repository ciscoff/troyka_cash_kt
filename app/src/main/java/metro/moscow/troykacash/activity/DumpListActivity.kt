package metro.moscow.troykacash.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import metro.moscow.troykacash.R
import metro.moscow.troykacash.presenter.DumpListPresenter
import metro.moscow.troykacash.presenter.Presenter
import metro.moscow.troykacash.presenter.TroykaView
import java.io.File

class DumpListActivity: AppCompatActivity(), TroykaView {

    /**
     * Presenter for current activity
     */
    val presenter: Presenter = DumpListPresenter(this);

    /**
     * @savedInstanceState через extra получает cardId выбранной карты
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dumplist)

        // Элемент ListView
        val lvDumps = findViewById<ListView>(R.id.lvDumps)
        // Элемент TextView (для отладки, потом удалить)
        val textView = findViewById<TextView>(R.id.dumpFile)
        // Номер карты, переданный через intent
        val cardId = intent.getStringExtra(getString(R.string.card_id))


        // Каталог "TROYKA/cardId" на флешке
        val dir = File(presenter.getAppDir(), cardId);
//        textView.text = dir.absolutePath


        // Список файлов в каталоге dir
        val files = presenter.fileList(dir)
//        for(file in files.orEmpty()) {
//            textView.append("\n" + file.name)
//        }

        // Адаптер к массиву строк с именами файлов
        val adapter = ArrayAdapter<String>(this, R.layout.item_dumplist, files.orEmpty().map { it.name })
        // Подключить ListView к данным
        lvDumps.adapter = adapter

        // Как легко и просто вставляется функция :)
        lvDumps.setOnItemClickListener {parent, view, position, id ->
            // Получить имя файла выбранного дампа
            val file = (view as android.widget.TextView).text

            val intent = Intent()
            intent.putExtra(getString(R.string.card_id), cardId)
            intent.putExtra(getString(R.string.dump_file), file)
            setResult(-1, intent)
            finish()
        }
    }
}

