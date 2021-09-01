

fun question(list: List<Int>): List<ResultT> {
    val hashmap : HashMap<Int, Int> = HashMap()

    val ans : MutableList<ResultT> = ArrayList()
    for(i in list){
        hashmap.put(i, hashmap.getOrDefault(i, 0)+1)
    }

   for ( key in hashmap.keys){
       val g = hashmap.get(key)
       if (g ?: 0 > 1) {
           ans.add(ResultT(key, hashmap.get(key)!!))
       }
   }

    return ans
}

data class ResultT(val num: Int, val count: Int){
    override fun toString(): String {
        return "${num}:${count}"
    }
};


fun main() {
    print(question(listOf(1,2,3,4,6,6,7,8,9,5,2,6,1,8,6,6,8,8)))
}