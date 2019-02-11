package metro.moscow.troykacash.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import metro.moscow.troykacash.R
import metro.moscow.troykacash.presenter.TroykaView

class BurnActivity: AppCompatActivity(), TroykaView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)
    }


}
