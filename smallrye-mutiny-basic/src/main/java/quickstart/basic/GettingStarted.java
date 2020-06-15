package quickstart.basic;

import io.smallrye.mutiny.Multi;

public class GettingStarted {

    public static void main(String[] args) {
        Multi<String> multi = Multi.createFrom().items("hello", "world");

        System.out.println(multi.getClass());

        multi.onItem().apply(s -> s.toUpperCase() + " ")
             .onCompletion().continueWith("!")
             .subscribe().with(System.out::print);

    }

}
