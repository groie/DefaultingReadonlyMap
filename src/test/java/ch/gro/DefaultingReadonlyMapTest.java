package ch.gro;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by gro on 17/09/15.
 */
public class DefaultingReadonlyMapTest {

    @Test
    public void testCreatingEmptyDefaultMapRemainsEmpty() throws Exception {
        Map<String, String> foo = new DefaultingReadonlyMap<>(new HashMap<>(), new HashMap<>());
        assertTrue(foo.isEmpty());
    }

    @Test
    public void testAddingItemToFirstMapMakesItFull() throws Exception {
        HashMap<String, String> DefaultingReadonlyMap = new HashMap<>();
        DefaultingReadonlyMap.put("Foo", "bar");
        Map<String, String> foo = new DefaultingReadonlyMap<>(DefaultingReadonlyMap, new HashMap<>());
        assertFalse(foo.isEmpty());
    }

    @Test
    public void testAddingItemToFallbackMapMakesItFull() throws Exception {
        HashMap<String, String> fallback = new HashMap<>();
        fallback.put("Foo", "bar");
        Map<String, String> foo = new DefaultingReadonlyMap<>(new HashMap<>(), fallback);
        assertFalse(foo.isEmpty());
    }

    @Test
    public void testAddingItemToBothMapsMakesItFull() throws Exception {
        HashMap<String, String> fallback = new HashMap<>();
        fallback.put("Foo", "bar");
        HashMap<String, String> defaultMap = new HashMap<>();
        defaultMap.put("Foo", "bar");
        Map<String, String> foo = new DefaultingReadonlyMap<>(defaultMap, fallback);
        assertFalse(foo.isEmpty());
    }


    @Test
    public void testEmptyHasZeroElements() throws Exception {
        Map<String, String> foo = new DefaultingReadonlyMap<>(new HashMap<>(), new HashMap<>());
        assertEquals(0, foo.size());
    }

    @Test
    public void testAddingItemToFirstMapMakesItContainOne() throws Exception {
        HashMap<String, String> DefaultingReadonlyMap = new HashMap<>();
        DefaultingReadonlyMap.put("Foo", "bar");
        Map<String, String> foo = new DefaultingReadonlyMap<>(DefaultingReadonlyMap, new HashMap<>());
        assertEquals(1, foo.size());
    }

    @Test
    public void testAddingSameKeyToBothMapsMakesItContainOne() throws Exception {
        HashMap<String, String> fallback = new HashMap<>();
        fallback.put("Foo", "bar");
        HashMap<String, String> defaultMap = new HashMap<>();
        defaultMap.put("Foo", "bar");
        Map<String, String> foo = new DefaultingReadonlyMap<>(defaultMap, fallback);
        assertEquals(1, foo.size());
    }


}