import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Essey Yohannes
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i])
                    : "" + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i])
                    : "" + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     * Constructor test.
     */
    @Test
    public final void mapOnQueueConstructorTest() {

        Map<String, String> s = this.createFromArgsTest("john", "short", "mike", "tall");
        Map<String, String> sExpected = this.createFromArgsRef("john", "short", "mike",
                "tall");

        assertEquals(sExpected, s);
    }

    /**
     * Add method test.
     */
    @Test
    public final void setOnQueueAddTest() {

        String key3 = "lili";
        String key4 = "Dave";

        Map<String, String> s = this.createFromArgsTest("john", "short", "mike", "tall");
        Map<String, String> sExpected = this.createFromArgsRef("john", "short", "mike",
                "tall", "lili", "short", "Dave", "tall");
        s.add(key3, "short");
        s.add(key4, "tall");

        assertEquals(sExpected, s);
    }

    /**
     * Remove method test.
     */

    @Test
    public final void mapOnQueueRemoveTest() {

        Map<String, String> s = this.createFromArgsTest("john", "short", "mike", "tall",
                "lili", "short", "Dave", "tall");
        Map<String, String> sExpected = this.createFromArgsRef("john", "short", "mike",
                "tall");

        s.remove("lili");
        s.remove("Dave");

        assertEquals(sExpected, s);
    }

    /**
     * RemoveAny method test.
     */

    @Test
    public final void maptOnQueueRemoveAnyTest() {

        Map<String, String> s = this.createFromArgsTest("john", "short", "mike", "tall",
                "lili", "short", "Dave", "tall");
        Map<String, String> sExpected = this.createFromArgsRef("john", "short", "mike",
                "tall");
        s.removeAny();
        s.removeAny();

        assertEquals(sExpected.size(), s.size());
    }

    /**
     * Value method test.
     */

    @Test
    public final void setOnQueueValueTest() {
        String key1 = "john";
        String key2 = "mike";

        Map<String, String> s = this.createFromArgsTest(key1, "short", key2, "tall");
        Map<String, String> sExpected = this.createFromArgsRef(key1, "short", key2,
                "tall");

        String result = s.value(key1);
        String resultExpected = sExpected.value(key1);

        assertEquals(resultExpected, result);
    }

    /**
     * HasKey method test.
     */

    @Test
    public final void setOnQueueHasKeyTest() {
        String key1 = "john";
        String key2 = "mike";

        Map<String, String> s = this.createFromArgsTest(key1, "short", key2, "tall");
        Map<String, String> sExpected = this.createFromArgsRef(key1, "short", key2,
                "tall");

        boolean found = s.hasKey(key2);
        boolean foundExpected = sExpected.hasKey(key2);

        assertEquals(foundExpected, found);
    }

    /**
     * Size method test.
     */

    @Test
    public final void setOnQueueSizeTest() {
        String key1 = "john";
        String key2 = "mike";

        Map<String, String> s = this.createFromArgsTest(key1, "short", key2, "tall");
        Map<String, String> sExpected = this.createFromArgsRef(key1, "short", key2,
                "tall");

        assertEquals(sExpected.size(), s.size());
    }

}
