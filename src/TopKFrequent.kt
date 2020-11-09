import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors
import kotlin.collections.HashMap

class TopKFrequent {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map: HashMap<Int, Int> = hashMapOf()
        for (value in nums) map[value] = map.getOrDefault(value, 0) + 1
        val list = map.entries.stream().sorted { o1, o2 -> o2.value - o1.value }
                .map { it.key }.collect(Collectors.toList())
        return list.subList(0, k).toIntArray()
    }

}