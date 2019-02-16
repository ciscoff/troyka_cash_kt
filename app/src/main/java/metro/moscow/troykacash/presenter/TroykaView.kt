package metro.moscow.troykacash.presenter

import android.content.Context
import metro.moscow.troykacash.TroykaCashApp

interface TroykaView {
    fun showInfo(info: String): Unit {
        return
    }

    fun startActivity(extraKeyId: Int, extraVal: String, requestCode: Int, cls: Class<*>) {
        return
    }

    fun getContext(): Context {
        return TroykaCashApp.applicationContext()
    }
}