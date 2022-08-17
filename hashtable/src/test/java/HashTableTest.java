import com.github.pioneeryi.HashTable;
import org.junit.Assert;
import org.junit.Test;

/**
 * HashTableTest.
 *
 * @author yixianfeng
 * @since 2022/8/17 17:55
 */
public class HashTableTest {

    private HashTable hashTable = new HashTable();

    @Test
    public void test1() {
        hashTable.add(1,11);
        hashTable.add(2,12);
        hashTable.add(3,13);
        hashTable.add(4,14);
        hashTable.add(5,15);
        hashTable.add(6,16);

        Assert.assertEquals(11,hashTable.get(1).intValue());
        Assert.assertEquals(16,hashTable.get(6).intValue());
        Assert.assertEquals(12,hashTable.get(2).intValue());
        Assert.assertEquals(14,hashTable.get(4).intValue());
    }

    @Test
    public void testRemove(){
        hashTable.add(2,12);
        hashTable.add(7,17);
        hashTable.add(12,112);

        Assert.assertEquals(17,hashTable.get(7).intValue());
        hashTable.remove(7);
        Assert.assertNull(hashTable.get(7));
    }
}
