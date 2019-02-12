package metro.moscow.troykacash.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import metro.moscow.troykacash.R
import metro.moscow.troykacash.presenter.Presenter
import metro.moscow.troykacash.presenter.ReadyPresenter
import metro.moscow.troykacash.presenter.TroykaView
import metro.moscow.troykacash.utils.SharedData

class ReadyActivity : AppCompatActivity(), TroykaView {

    /**
     * Presenter for current activity
     */
    val presenter: Presenter = ReadyPresenter(this);

    /**
     * TODO: Create activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)

        val txtView = findViewById<TextView>(R.id.readyTextView)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnCancel = findViewById<Button>(R.id.btnCancel)
    }

    /**
     * TODO: Create drop menu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val subMenu = menu?.addSubMenu(R.string.card_menu)

        for (item in SharedData.menuItems) subMenu?.add(item)
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * TODO: Когда юзер выбирает номер карты, то должно открыться активити
     * TODO: со списком её дампов. Дочернее активити должно вернуть имя выбранного
     * TODO: файла
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val cardId = item.title

        SharedData.menuItems.toList().contains(cardId)

        return true;
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
