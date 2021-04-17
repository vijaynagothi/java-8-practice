package academy.elqoo.java8.stream;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
    	return numbers.stream()
            	.map(s -> (int) Math.sqrt(s))
            	.collect(Collectors.toList());
    }

    public static List<Integer> getAgeFromUsers(List<User> user){
    	return user.stream()
            	.map(User::getAge)
            	.collect(Collectors.toList());
    }

    public static List<Integer> getDistinctAges(List<User> users){
        return users.stream()
        		.map(User::getAge)
        		.distinct()
        		.collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
    	return users.stream()
    			.limit(limit)
    			.collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users){
        return (int) users.stream()
        		.filter(u -> u.getAge() > 25)
        		.count();
    }

    public static List<String> mapToUpperCase(List<String> strings){
        return strings.stream()
        	.map(s -> s.toUpperCase())
        	.collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers){
        return integers.stream()
        		.mapToInt(i -> i)
        		.sum();
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
        return integers.stream()
        		.skip(2)
        		.collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names){
        return names.stream()
        		.map(s -> s.split(" ")[0])
        		.collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names){
        return names.stream()
        		.map(c -> c.split(""))
        		.flatMap(Arrays::stream)
        		.distinct()
        		.collect(Collectors.toList());
    }


    public static String separateNamesByComma(List<User> users){
    	StringBuilder sb = new StringBuilder();
        return users.stream()
        		.map(User::getName)
        		.collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users){
    	return users.stream()
        		.mapToInt(User::getAge)
        		.average()
        		.getAsDouble();
    }

    public static Integer getMaxAge(List<User> users){
    	return users.stream()
        		.map(User::getAge)
        		.max(Integer::compare)
        		.get();
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream()
        		.map(User::getAge)
        		.min(Integer::compare)
        		.get();
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        return users.stream()
        		.collect(Collectors.partitioningBy(s -> s.isMale()));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        return users.stream()
        		.collect(Collectors.groupingBy(User::getAge));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
        return users.stream()
        		.collect(Collectors.groupingBy(User::isMale, Collectors.groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        return users.stream()
        		.collect(Collectors.groupingBy(User::isMale, Collectors.counting()));
    }

    public static boolean anyMatch(List<User> users, int age){
        return users.parallelStream()
        		.anyMatch(s -> s.getAge()== age);
    }

    public static boolean noneMatch(List<User> users, int age){
    	return users.parallelStream()
        		.noneMatch(s -> s.getAge()== age);
    }

    public static Optional<User> findAny(List<User> users, String name){
        return users.parallelStream()
        		.filter(s -> s.getName() == name)
        		.findAny();
    }

    public static List<User> sortByAge(List<User> users){
    	return users.parallelStream()
        		.sorted((a, b) -> a.getAge().compareTo(b.getAge()))
        		.collect(Collectors.toList());
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
        return IntStream.rangeClosed(2, Integer.MAX_VALUE)
        		.filter(s -> isPrimeStreamed(s))
        		.limit(10)
        		.boxed()
        		.collect(Collectors.toList());
    }
    
    public static boolean isPrimeStreamed(int number) {
    	return IntStream.rangeClosed(2, (int) Math.sqrt(number))
    			.allMatch(n -> number % n != 0);
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        return new Random()
        		.ints(10)
        		.boxed()
        		.collect(Collectors.toList());
    }

    public static User findOldest(List<User> users){
        return users.stream()
        		.max(Comparator.comparing(User::getAge))
        		.get();
    }

    public static int sumAge(List<User> users){
        return (int) users.stream()
        		.collect(Collectors.summarizingInt(User::getAge))
        		.getSum();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        return users.stream()
        		.collect(Collectors.summarizingInt(User::getAge));
    }

}
