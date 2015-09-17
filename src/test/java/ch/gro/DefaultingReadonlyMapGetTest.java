package ch.gro;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DefaultingReadonlyMapGetTest {

    @Test
    public void testAddingSameKeyToBothMapsReturnsDefault() throws Exception {
        HashMap<String, String> defaultMap = new HashMap<>();
        defaultMap.put("Foo", "bar");
        HashMap<String, String> fallback = new HashMap<>();
        fallback.put("Foo", "baz");
        Map<String, String> foo = new DefaultingReadonlyMap<>(defaultMap, fallback);
        assertEquals("bar", foo.get("Foo"));
    }

    @Test
    public void testAddingToFirstMapReturnsIt() throws Exception {
        HashMap<String, String> defaultMap = new HashMap<>();
        defaultMap.put("Foo", "bar");
        Map<String, String> foo = new DefaultingReadonlyMap<>(defaultMap, new HashMap<>());
        assertEquals("bar", foo.get("Foo"));
    }

    @Test
    public void testAddingToSecondMapReturnsDefault() throws Exception {
        HashMap<String, String> fallback = new HashMap<>();
        fallback.put("Foo", "baz");
        Map<String, String> foo = new DefaultingReadonlyMap<>(new HashMap<>(), fallback);
        assertEquals("baz", foo.get("Foo"));
    }

    @Test
    public void testEmptyMapReturnsNull() throws Exception {
        Map<String, String> foo = new DefaultingReadonlyMap<>(new HashMap<>(), new HashMap<>());
        assertNull(foo.get("Foo"));
    }
}
