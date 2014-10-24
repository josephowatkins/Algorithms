package heapsort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class SortScript {

    private Random random = new Random();

    public static void main(String[] args) {
        SortScript ss = new SortScript();
        ss.launch();
    }

    private void launch() {

        System.out.println(Runtime.getRuntime().availableProcessors());

        Integer[] sortMe = Stream.generate(() -> random.nextInt(10000))
                .limit(10000).toArray(Integer[]::new);

        //Before sort
        System.out.println(Arrays.toString(sortMe));

        HeapSort hs = new HeapSort();
        hs.sort(sortMe);

        //after sort
        System.out.println(Arrays.toString(sortMe));

    }
}
