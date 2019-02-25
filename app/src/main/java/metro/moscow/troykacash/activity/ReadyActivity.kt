package metro.moscow.troykacash.activity

import android.content.Context
import android.content.Intent
import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import metro.moscow.troykacash.R
import metro.moscow.troykacash.TroykaCashApp
import metro.moscow.troykacash.dao.FileHelper
import metro.moscow.troykacash.interactor.ReadyInteractor
import metro.moscow.troykacash.presenter.Presenter
import metro.moscow.troykacash.presenter.ReadyPresenter
import metro.moscow.troykacash.presenter.TroykaView
import metro.moscow.troykacash.repository.DumpRepositoryImpl
import metro.moscow.troykacash.utils.SharedData

class ReadyActivity : AppCompatActivity(), TroykaView {

    companion object {
        const val REQUEST_PERMISSION = 1
    }


    /**
     * Presenter for current activity
     */
    val presenter: ReadyPresenter = createPresenter()

    /**
     * TODO: Create activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)

//        val txtView = findViewById<TextView>(R.id.readyTextView)
//        val btnSave = findViewById<Button>(R.id.btnSave)
//        val btnCancel = findViewById<Button>(R.id.btnCancel)

    }

    /**
     * TODO: onStart handler
     */
    override fun onStart() {
        super.onStart()
        presenter.onStart()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_PERMISSION)
        } else {

        }
    }

    /**
     * TODO: onStop handler
     */
    override fun onStop() {
        super.onStop()
        presenter.onStop()
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
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    /**
     * TODO: Запустить активити
     */
    override fun startActivity(keyId: Int, value: String, requestCode: Int, cls: Class<*>) {
        val intent = Intent(this, cls)
        // Put <key, value> pair
        intent.putExtra(getString(keyId), value)
        startActivityForResult(intent, requestCode)
    }

    /**
     * TODO: Создать презентер, нацеленный на нужную репозиторию
     */
    private fun createPresenter(): ReadyPresenter {
        val fileHelper = (getContext() as TroykaCashApp).fileHelper
        val dumpRepo = DumpRepositoryImpl(fileHelper)
        val interactor = ReadyInteractor(dumpRepo)
        return ReadyPresenter(this, interactor)
    }

}
