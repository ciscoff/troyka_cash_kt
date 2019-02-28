/**
 * Источники:
 *
 * Темы и стили
 * http://developer.alexanderklimov.ru/android/theme.php
 *
 * Коллекции в Kotlin
 * http://developer.alexanderklimov.ru/android/kotlin/collection.php#find
 *
 */

package metro.moscow.troykacash.utils

import android.util.Log
import metro.moscow.troykacash.utils.SharedData.Companion.LOG_ID

object Utils {
    fun logI(message: String) {
        Log.i(LOG_ID, message)
    }
}