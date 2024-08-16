package cn.bravedawn.collection.list.deweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/8/14 11:13
 */
public class ListDeWeightExample {

    /**
     * List去重
     */


    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Alice", 20), // Duplicate name
                new Person("Charlie", 35)
        );

        // Using a map to deduplicate by the 'name' property
        Map<String, Person> uniquePeople = people.stream()
                .collect(Collectors.toMap(
                        Person::getName, // KeyExtractor: the property to use for deduplication
                        Function.identity(), // ValueMapper: maps the element to itself
                        (existing, replacement) -> existing // MergeFunction: in case of key collision, keep the existing value
                ));

        // Convert the map back to a list if needed
        List<Person> uniquePeopleList = new ArrayList<>(uniquePeople.values());

        // Print the unique people
        uniquePeopleList.forEach(System.out::println);
    }
}
