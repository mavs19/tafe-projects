// David Perry
// 30010019
// 6 February 2020
// Nested Classes with data stored on Doubly Linked List
package portfolioq1;

// Class Counrty with field, Constructors and getter
public class Country {

    private String name;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Nested Class city with field, constructors and getter
    public class City {

        private String name;

        public City() {

        }

        public City(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
