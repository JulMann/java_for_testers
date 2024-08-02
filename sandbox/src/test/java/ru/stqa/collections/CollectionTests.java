package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests() {
        //var array = new String[]{"a", "b", "c"};
        var array = new String[3];
        Assertions.assertEquals(3, array.length);
        array[0] = "a";
        Assertions.assertEquals("a", array[0]);

        array[0] = "d";
        Assertions.assertEquals("d", array[0]);
    }

    @Test
    void listTests() {
        var list = new ArrayList<String>();
        Assertions.assertEquals(0, list.size());

        list.add("a");
        list.add("b");
        list.add("c");

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0, "d");
        Assertions.assertEquals("d", list.get(0));

        var list2 = List.of("a", "b", "c");

        var list3 = new ArrayList<>(List.of("a", "b", "c"));
        Assertions.assertEquals(3, list3.size());
        Assertions.assertEquals("a", list3.get(0));

        list3.set(0, "d");
        Assertions.assertEquals("d", list3.get(0));
    }
}
