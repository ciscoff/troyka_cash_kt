package metro.moscow.troykacash.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import metro.moscow.troykacash.R
import metro.moscow.troykacash.presenter.Presenter
import metro.moscow.troykacash.presenter.ReadyPresenter
import metro.moscow.troykacash.presenter.TroykaView
import metro.moscow.troykacash.utils.SharedData

class ReadyActivity : AppCompatActivity(), TroykaView {

    /**
     * Presenter for current activity
     */
    val presenter: Presenter = ReadyPresenter(this, null)

    /**
     * TODO: Create activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)

        val txtView = findViewById<TextView>(R.id.readyTextView)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        presenter.onStart()
    }

    /**
     * TODO: Create drop menu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val subMenu = menu?.addSubMenu(R.string.card_menu)

        for (item in presenter.getMenuItems()) subMenu?.add(item)
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * TODO: Когда юзер выбирает номер карты, то должно открыться активити
     * TODO: со списком её дампов. Дочернее активити должно вернуть имя выбранного
     * TODO: файла
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        presenter.onMenuSelected(item.title.toString())
        return super.onOptionsItemSelected(item)
    }

    /**
     * TODO: Получаем имя выбранного файла с дампом
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val file = data?.getStringExtra(getString(R.string.dump_file))
        val cardId = data?.getStringExtra(getString(R.string.card_id))

        Toast.makeText(this, "Dump file is: " + file + "\ncardId is: " + cardId, Toast.LENGTH_LONG).show()
    }

    /**
     * TODO: Запустить активити
     */
    override fun startActivity(keyId: Int, value: String, cls: Class<*>) {
        val intent = Intent(this, cls)
        // Put <key, value> pair
        intent.putExtra(getString(keyId), value)
        startActivityForResult(intent, 1)
    }
}
