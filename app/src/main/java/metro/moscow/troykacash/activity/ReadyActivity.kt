package metro.moscow.troykacash.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import metro.moscow.troykacash.R
import metro.moscow.troykacash.presenter.TroykaView

class ReadyActivity : AppCompatActivity(), TroykaView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)
    }
}
