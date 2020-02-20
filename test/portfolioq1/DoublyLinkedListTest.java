//David Perry
//30010019
//20 February 2020
//Test class for Doubly Linked List
package portfolioq1;

import java.util.LinkedList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static junit.framework.TestCase.assertEquals;
import org.junit.*;

public class DoublyLinkedListTest {

    public DoublyLinkedListTest() {

    }

    DoublyLinkedList<Country> countries = new DoublyLinkedList<>();
    Country australia = new Country("Australia");
    Country unitedStates = new Country("United States");
    Country canada = new Country("Canada");
    Country china = new Country("China");

    //A test to check the add First method adds data to the front of list by comparing to an expected outcome array
    @Test
    public void testaddFirst() throws Exception {
        LinkedList<String> newCountries = new LinkedList<>();
        Country australia = new Country("Australia");
        Country unitedStates = new Country("United States");
        newCountries.addFirst(australia.getName());
        newCountries.addFirst(unitedStates.getName());
        String[] expected = {"United States", "Australia"};

        String newList[] = newCountries.toArray(new String[newCountries.size()]);
        assertThat(newList, is(expected));

    }
    // Test to check data is added to the last spot on list by comparing to an expected outcome array
    @Test
    public void testAddLast() throws Exception {

        LinkedList<String> newCountries = new LinkedList<>();
        Country australia = new Country("Australia");
        Country canada = new Country("Canada");
        Country unitedStates = new Country("United States");
        Country china = new Country("China");

        String[] expected = {"Canada", "Australia", "United States"};

        newCountries.addFirst(australia.getName());
        newCountries.addFirst(canada.getName());
        newCountries.addLast(unitedStates.getName());
        String newList[] = newCountries.toArray(new String[newCountries.size()]);
        assertThat(newList, is(expected));
    }
    // Test to check the length of the list is what's expected
    @Test
    public void testAddAfter() throws Exception {

        countries.addFirst(australia.getName());
        countries.addFirst(unitedStates.getName());
        countries.addAfter(countries.head, china.getName());
        assertEquals(3, countries.length());
        

    }
}
