package metro.moscow.troykacash.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import metro.moscow.troykacash.presenter.TroykaView
import metro.moscow.troykacash.R

class SaveActivity: AppCompatActivity(), TroykaView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)
    }
}

