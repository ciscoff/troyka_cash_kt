/**
 * Materials:
 * http://java-help.ru/singleton-in-kotlin/
 */

package metro.moscow.troykacash.dao

/**
 * Класс для работы с NFC. Реализуется как Singleton
 */
public class NfcHelper private constructor() {
    private object NfcHolder {
        val INSTANCE = NfcHelper()
    }

    companion object {
        val instance: NfcHelper by lazy { NfcHolder.INSTANCE }
    }
}