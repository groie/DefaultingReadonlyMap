package ch.gro;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gro on 17/09/15.
 */
public class DefaultingReadonlyMapWriteProtectedTest {

    private Map<String, String> testMap = new DefaultingReadonlyMap<>(new HashMap<>(), new HashMap<>());

    @Test(expected = NoModificationAllowedException.class)
    public void testPutAll() throws Exception {
        testMap.putAll(new HashMap<>());
    }

    @Test(expected = NoModificationAllowedException.class)
         public void testPut() throws Exception {
        testMap.put("aa", "bee");
    }

    @Test(expected = NoModificationAllowedException.class)
    public void testRemove() throws Exception {
        testMap.remove("aa");
    }

    @Test(expected = NoModificationAllowedException.class)
    public void testClear() throws Exception {
        testMap.clear();
    }

}
