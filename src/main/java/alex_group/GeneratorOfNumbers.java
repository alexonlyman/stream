package alex_group;

import alex_group.model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GeneratorOfNumbers {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
        List<Map.Entry<String, Double>> topThreeProducts = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getProduct,
                        Collectors.summingDouble(Order::getCost)
                ))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(3)
                .toList();

        topThreeProducts.forEach(entry ->
                System.out.println(entry.getKey() + ": $" + entry.getValue())
        );
    }
}