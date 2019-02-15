package metro.moscow.troykacash.presenter

interface TroykaView {
    fun showInfo(info: String): Unit {
        return
    }

    fun startActivity(extraKeyId: Int, extraVal: String, requestCode: Int, cls: Class<*>) {
        return
    }
}