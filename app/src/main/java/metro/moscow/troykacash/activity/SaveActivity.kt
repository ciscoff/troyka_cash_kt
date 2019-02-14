package metro.moscow.troykacash.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import metro.moscow.troykacash.presenter.TroykaView
import metro.moscow.troykacash.R
import metro.moscow.troykacash.presenter.Presenter
import metro.moscow.troykacash.presenter.SavePresenter

class SaveActivity: AppCompatActivity(), TroykaView {
    /**
     * Presenter for current activity
     */
    val presenter: Presenter = SavePresenter(this, null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)
    }
}

