package com.lidia.algorithms.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * https://mkyong.com/java/java-jmh-benchmark-tutorial/
 * 
 * Review the result, to loop a List containing 10 million String objects, the
 * classic while loop is the fastest loop in demo. but in my results the for
 * look is quickest. However, the difference isn’t that significant.
 * 
 * % mvn package 
 * % java -jar target/Benchmark.jar BenchmarkLoop
 * 
 * Benchmark                          (N) Mode Cnt Score Error Units 
 * BenchmarkLoop.loopFor         10000000 avgt 10 60.680 2.023 ms/op 
 * BenchmarkLoop.loopForEach     10000000 avgt 10 68.296 2.389 ms/op 
 * BenchmarkLoop.loopIterator    10000000 avgt 10 74.578 22.213 ms/op
 * BenchmarkLoop.loopWhile       10000000 avgt 10 66.997 9.973 ms/op
 * 
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
// We even can warm up the entire fork, before started the real fork for measuring.
//@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 2) 
// Warmup iteration and measuring iteration are configurable :
//@Warmup(iterations = 3)
//@Measurement(iterations = 8)
public class BenchmarkLoop {

    @Param({"10000000"})
    private int N;

    private List<String> DATA_FOR_TESTING;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkLoop.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        DATA_FOR_TESTING = createData();
    }

    @Benchmark
    public void loopFor(Blackhole bh) {
        for (int i = 0; i < DATA_FOR_TESTING.size(); i++) {
            String s = DATA_FOR_TESTING.get(i); //take out n consume, fair with foreach
            bh.consume(s);
        }
    }

    @Benchmark
    public void loopWhile(Blackhole bh) {
        int i = 0;
        while (i < DATA_FOR_TESTING.size()) {
            String s = DATA_FOR_TESTING.get(i);
            bh.consume(s);
            i++;
        }
    }

    @Benchmark
    public void loopForEach(Blackhole bh) {
        for (String s : DATA_FOR_TESTING) {
            bh.consume(s);
        }
    }

    @Benchmark
    public void loopIterator(Blackhole bh) {
        Iterator<String> iterator = DATA_FOR_TESTING.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            bh.consume(s);
        }
    }

    private List<String> createData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            data.add("Number : " + i);
        }
        return data;
    }

}