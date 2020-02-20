// David Perry
// 30010019
// 6 February 2020
// Nested Classes with data stored on Doubly Linked List
package portfolioq1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class DoublyLinkedList<E> {

    // Node head set globally to the node at front of list
    public Node head;

    //Doubly Linked list Node
    private class Node {

        private String data;
        private Node prev;
        private Node next;

        // Constructor to create a new node with data being type string
        Node(String data) {
            this.data = data;
        }
    }

    // Method to check the length of the list
    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // Method to add a node at the start of list, a new node object is created
    // The New node added will end up as the head, if the list was empty prev will be set to null
    public void addFirst(String NewNode) {

        Node newNode = new Node(NewNode);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // Method to add node after last entry, the parameter prevNode requires the head data when method called
    // This method will display a message if the list is empty, otherwise data will be added after head node
    public void addAfter(Node prevNode, String newData) {

        if (prevNode == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    // Method to add data to the last node, if the list is empty the new node will be head
    // The New Node will traverse the list and up in the last position 
    public void addLast(String newData) {

        Node newNode = new Node(newData);
        Node last = head;
        newNode.next = null;
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    // Method to print countries in a forward direction, then in a reverse direction
    public void printCountries(Node node) {
        Node last = null;
        System.out.println("Printing countries in forward Direction");
        while (node != null) {
            System.out.print(node.data + "\n");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Printing countries in reverse direction");
        while (last != null) {
            System.out.print(last.data + "\n");
            last = last.prev;
        }
    }

    // Method to print cities
    public void printCities(Node node) {
        while (node != null) {
            System.out.print(node.data + "\n");
            node = node.next;
        }
    }

    // Main method, Doubly linked lists created for the countries and cities
    // Objects created, then added to the lists
    // A set of switch statements used for the user to select a country's cities to display
    public static void main(String[] args) {

        DoublyLinkedList<Country> countries = new DoublyLinkedList<>();
        Country australia = new Country("Australia");
        Country canada = new Country("Canada");
        Country unitedStates = new Country("United States");
        Country china = new Country("China");
        countries.addFirst(australia.getName());
        countries.addLast(canada.getName());
        countries.addFirst(unitedStates.getName());
        countries.addAfter(countries.head, china.getName());
        countries.printCountries(countries.head);

        DoublyLinkedList<Country> australianCities = new DoublyLinkedList<>();
        Country.City perth = australia.new City("Perth");
        Country.City brisbane = australia.new City("Brisbane");
        Country.City hobart = australia.new City("Hobart");
        Country.City melbourne = australia.new City("Melbourne");
        australianCities.addFirst(perth.getName());
        australianCities.addFirst(brisbane.getName());
        australianCities.addFirst(hobart.getName());
        australianCities.addFirst(melbourne.getName());

        DoublyLinkedList<Country> canadianCities = new DoublyLinkedList<>();
        Country.City ottawa = canada.new City("Ottawa");
        Country.City vancouver = canada.new City("Vancouver");
        Country.City montreal = canada.new City("Montreal");
        Country.City toronto = canada.new City("Toronto");
        canadianCities.addFirst(ottawa.getName());
        canadianCities.addFirst(vancouver.getName());
        canadianCities.addFirst(montreal.getName());
        canadianCities.addFirst(toronto.getName());

        DoublyLinkedList<Country> usaCities = new DoublyLinkedList<>();
        Country.City sanFransisco = unitedStates.new City("San Fransisco");
        Country.City seattle = unitedStates.new City("Seattle");
        Country.City losAngeles = unitedStates.new City("Los Angeles");
        Country.City portland = unitedStates.new City("Portland");
        usaCities.addFirst(sanFransisco.getName());
        usaCities.addFirst(seattle.getName());
        usaCities.addFirst(losAngeles.getName());
        usaCities.addFirst(portland.getName());

        DoublyLinkedList<Country> chineseCities = new DoublyLinkedList<>();
        Country.City beijing = china.new City("Beijing");
        Country.City shanghai = china.new City("Shanghai");
        Country.City shenzhen = china.new City("Shenzhen");
        Country.City guangzhou = china.new City("Guangzhou");
        chineseCities.addFirst(beijing.getName());
        chineseCities.addFirst(shanghai.getName());
        chineseCities.addFirst(shenzhen.getName());
        chineseCities.addFirst(guangzhou.getName());

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int choice = 0;
        printCityInstructions();
        try {
            while (!quit) {
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                if ((choice > 5) || (choice < 0)) {
                    System.out.println("Please enter a number from 0-5");
                } else {
                    switch (choice) {
                        case 0:
                            printCityInstructions();
                            break;
                        case 1:
                            System.out.println("Printing cities from Australia");
                            countries.printCities(australianCities.head);
                            break;
                        case 2:
                            System.out.println("Printing cities from Canada");
                            countries.printCities(canadianCities.head);
                            break;
                        case 3:
                            System.out.println("Printing cities from United States");
                            countries.printCities(usaCities.head);
                            break;
                        case 4:
                            System.out.println("Printing cities from China");
                            countries.printCities(chineseCities.head);
                            break;
                        case 5:
                            System.out.println("Exiting....");
                            quit = true;
                            break;
                    }
                }
            }
        } catch (InputMismatchException e) {

            System.out.println(e.toString());
            System.out.println("Please enter an Integer");
        }
    }

    // Method to call a simple set of instructions used in the switch statement user input
    public static void printCityInstructions() {
        System.out.println("\nPress ");
        System.out.println("0 - To print choice options.");
        System.out.println("1 - To print the cities of Australia.");
        System.out.println("2 - To print the cities of Canada.");
        System.out.println("3 - To print the cities of United States.");
        System.out.println("4 - To To print the cities of China.");
        System.out.println("5 - To quit the application.");

    }

}
