package ch.gro;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DefaultingReadonlyMapContainsKeyAndValueTest {

    @Test
    public void testEmptyContainsNoKeyOrValue() throws Exception {
        Map<String, String> testMap = new DefaultingReadonlyMap<>(new HashMap<>(), new HashMap<>());
        assertFalse(testMap.containsKey("foo"));
        assertFalse(testMap.containsValue("foo"));
    }

    @Test
    public void testEmptyContainsKeyAndValue() throws Exception {
        HashMap<String, String> defaultMap = new HashMap<>();
        defaultMap.put("aa", "bb");
        Map<String, String> testMap = new DefaultingReadonlyMap<>(defaultMap, new HashMap<>());
        assertTrue(testMap.containsKey("aa"));
        assertTrue(testMap.containsValue("bb"));
    }

    @Test
    public void testEmptyContainsKeyButNoValue() throws Exception {
        HashMap<String, String> defaultMap = new HashMap<>();
        defaultMap.put("aa", "bb");
        Map<String, String> testMap = new DefaultingReadonlyMap<>(defaultMap, new HashMap<>());
        assertTrue(testMap.containsKey("aa"));
        assertFalse(testMap.containsValue("cc"));
    }

    @Test
    public void testFallbackValuesAreFound() throws Exception {
        HashMap<String, String> fallbackMap = new HashMap<>();
        fallbackMap.put("aa", "bb");
        Map<String, String> testMap = new DefaultingReadonlyMap<>(new HashMap<>(), fallbackMap);
        assertTrue(testMap.containsKey("aa"));
        assertTrue(testMap.containsValue("bb"));
        assertFalse(testMap.containsValue("cc"));
    }

    @Test
    public void testAddedToBothMapsAreFound() throws Exception {
        HashMap<String, String> defaultMap = new HashMap<>();
        defaultMap.put("aa", "bb");
        HashMap<String, String> fallbackMap = new HashMap<>();
        fallbackMap.put("cc", "dd");
        Map<String, String> testMap = new DefaultingReadonlyMap<>(defaultMap, fallbackMap);
        assertTrue(testMap.containsKey("aa"));
        assertTrue(testMap.containsValue("bb"));
        assertTrue(testMap.containsKey("cc"));
        assertTrue(testMap.containsValue("dd"));
    }
}
