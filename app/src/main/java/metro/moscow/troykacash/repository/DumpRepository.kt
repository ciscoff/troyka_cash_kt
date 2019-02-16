package metro.moscow.troykacash.repository

interface DumpRepository {
    fun getCardList() : Array<String>
    fun getDumpList(cardId: String): Array<String>

}