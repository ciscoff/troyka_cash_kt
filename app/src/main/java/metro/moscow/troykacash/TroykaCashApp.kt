/**
 * Как получить application context
 * https://gist.github.com/paraya3636/bf8108a75eb49323e56c0c90dd0747e0
 *
 *
 * Справочник по операторам и ключевым словам
 * https://kotlinlang.org/docs/reference/keyword-reference.html
 */

package metro.moscow.troykacash

import android.app.Application
import android.content.Context
import metro.moscow.troykacash.dao.FileHelper
import metro.moscow.troykacash.dao.NfcHelper

class TroykaCashApp : Application() {

    var fileHelper = FileHelper.instance
    var nfcHelper = NfcHelper.instance

    init {
        instance = this
    }

    companion object {
        private var instance: TroykaCashApp? = null

        fun applicationContext() : Context {
            // https://kotlinlang.org/docs/reference/null-safety.html#the--operator
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}