package quickstart.basic;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class UniAndMulti {

    public static void main(String[] args) {
        Multi.createFrom().items("a", "b", "c")
             .onItem().apply(i -> i.toUpperCase())
             .subscribe().with(
                               item -> System.out.println("Received: " + item),
                               failure -> System.out.println("Failed with " + failure.getMessage()));

        Uni.createFrom().item("a")
           .onItem().apply(i -> i.toUpperCase())
           .subscribe().with(
                             item -> System.out.println("Received: " + item),
                             failure -> System.out.println("Failed with " + failure.getMessage()));
    }

}
