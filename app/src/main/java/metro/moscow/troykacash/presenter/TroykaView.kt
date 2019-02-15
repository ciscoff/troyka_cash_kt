package metro.moscow.troykacash.presenter

interface TroykaView {
    fun showInfo(info: String): Unit {
        return
    }

    fun startActivity(extraKeyId: Int, extraVal: String, cls: Class<*>) {
        return
    }
}