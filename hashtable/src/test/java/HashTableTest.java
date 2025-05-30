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

    private HashTable<Integer,Integer> hashTable = new HashTable();

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
        hashTable.add(12,17);
        hashTable.add(22,112);

        Assert.assertEquals(17,hashTable.get(12).intValue());
        hashTable.remove(12);
        Assert.assertNull(hashTable.get(12));
    }

    @Test
    public void testExpandCapacity(){
        hashTable.add(1,11);
        hashTable.add(2,12);
        hashTable.add(3,13);
        hashTable.add(4,14);
        hashTable.add(5,15);
        hashTable.add(11,111);

        Assert.assertEquals(10,hashTable.capacity());
        Assert.assertEquals(111,hashTable.get(11).intValue());

        hashTable.add(12,112);
        Assert.assertEquals(20,hashTable.capacity());
        Assert.assertEquals(111,hashTable.get(11).intValue());
    }
}
