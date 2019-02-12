package metro.moscow.troykacash.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import metro.moscow.troykacash.R
import metro.moscow.troykacash.presenter.DumpListPresenter
import metro.moscow.troykacash.presenter.Presenter
import metro.moscow.troykacash.presenter.ReadyPresenter
import metro.moscow.troykacash.presenter.TroykaView

class DumpListActivity: AppCompatActivity(), TroykaView {

    /**
     * Presenter for current activity
     */
    val presenter: Presenter = DumpListPresenter(this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)
    }
}

