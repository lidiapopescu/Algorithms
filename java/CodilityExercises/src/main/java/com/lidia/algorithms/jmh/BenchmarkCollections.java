package com.lidia.algorithms.jmh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Level;
import java.util.concurrent.TimeUnit;
/**
 * https://www.baeldung.com/java-hashset-arraylist-contains-performance
 * We're interested in calculating an average running time. 
 * 
 * % mvn package 
 * % java -jar target/Benchmark.jar BenchmarkCollections
 * 
 * Result "com.lidia.algorithms.jmh.BenchmarkCollections.testArrayList":
 * 204.344 (99.9%) 6.877 ns/op [Average]
 * (min, avg, max) = (190.952, 204.344, 230.040), stdev = 9.180
 * CI (99.9%): [197.467, 211.220] (assumes normal distribution)
 * 
 * Result "com.lidia.algorithms.jmh.BenchmarkCollections.testHashSet":
 * 5.105 (99.9%) 0.075 ns/op [Average]
 * (min, avg, max) = (4.948, 5.105, 5.335), stdev = 0.100
 * CI (99.9%): [5.030, 5.179] (assumes normal distribution)
 * 
 * Benchmark                           Mode  Cnt    Score   Error  Units
 * BenchmarkCollections.testArrayList  avgt   25  204.344   6.877  ns/op
 * BenchmarkCollections.testHashSet    avgt   25    5.105   0.075  ns/op
 * 
 * We can clearly see that the testArrayList method has 204.344 ns average lookup score, 
 * while the testHashSet performs faster with 5.105 ns on average.
 * */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
public class BenchmarkCollections {

	@State(Scope.Thread)
    public static class MyState {
        private Set<Employee> employeeSet = new HashSet<>();
        private List<Employee> employeeList = new ArrayList<>();

        private long iterations = 1000;

        private Employee employee = new Employee(100L, "Harry");

        @Setup(Level.Trial)
        public void setUp() {

            for (long i = 0; i < iterations; i++) {
                employeeSet.add(new Employee(i, "John"));
                employeeList.add(new Employee(i, "John"));
            }

            // We add the employee = new Employee(100L, “Harry”) instance as the last elements to both collections. 
            // So we test the employee object's lookup time for the worst possible case.
            employeeList.add(employee);
            employeeSet.add(employee);
        }
    }
	
	@Benchmark
	public boolean testArrayList(MyState state) {
	    return state.employeeList.contains(state.employee);
	}
	
	@Benchmark
	public boolean testHashSet(MyState state) {
	    return state.employeeSet.contains(state.employee);
	}
	
	public static void main(String[] args) throws Exception {
	    Options options = new OptionsBuilder()
	      .include(BenchmarkCollections.class.getSimpleName())
	      .forks(1).build();
	    new Runner(options).run();
	}
}
