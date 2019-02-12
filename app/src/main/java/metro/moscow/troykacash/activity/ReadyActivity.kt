package metro.moscow.troykacash.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import metro.moscow.troykacash.R
import metro.moscow.troykacash.presenter.TroykaView

class ReadyActivity : AppCompatActivity(), TroykaView {

    /**
     * TODO: Create activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)
    }

    /**
     * TODO: Create drop menu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuItems: Array<String> = arrayOf("card1", "card2", "card3", "card4")
        val subMenu = menu?.addSubMenu(R.string.card_menu)

        for (item in menuItems) {
            subMenu?.add(item)
        }
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * TODO: Когда юзер выбирает номер карты, то должно открыться активити
     * TODO: со списком её дампов. Дочернее активити должно вернуть имя выбранного
     * TODO: файла
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return true;

    }
}
