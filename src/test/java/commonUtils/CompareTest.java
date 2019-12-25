package commonUtils;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static commonUtils.Compare.isTwoArrayEquals;
import static org.junit.Assert.assertEquals;


public class CompareTest {

    @Test
    public void isTwoArrayEqualsTest() {
        String[] arr1 = {"1","2","3"};
        String[] arr2 = {"1","2","2"};

        assertEquals(isTwoArrayEquals(arr1,arr2),false);

        String[] arr3 = {"1","2","3"};
        String[] arr4 = {"1","2","N"};

        assertEquals(isTwoArrayEquals(arr3,arr4,"N"),true);

        String[] arr5 = {"1","7","3"};
        String[] arr6 = {"1","M","N"};

        Set<String> anys = new HashSet<String>();
        anys.add("M");
        anys.add("N");
        assertEquals(isTwoArrayEquals(arr3,arr4,anys),true);

    }
}