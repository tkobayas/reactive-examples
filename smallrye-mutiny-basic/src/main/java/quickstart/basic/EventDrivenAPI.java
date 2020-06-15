package quickstart.basic;

import io.smallrye.mutiny.Multi;

public class EventDrivenAPI {

    public static void main(String[] args) {
        Multi<String> source = Multi.createFrom().items("a", "b", "c");

        source
              .onItem().invoke(item -> System.out.println("Received item " + item))
              .onFailure().invoke(failure -> System.out.println("Failed with " + failure.getMessage()))
              .onCompletion().invoke(() -> System.out.println("Completed"))
              .on().subscribed(subscription -> System.out.println("We are subscribed!"))

              .on().cancellation(() -> System.out.println("Downstream has cancelled the interaction"))
              .on().request(n -> System.out.println("Downstream requested " + n + " items"))
              .subscribe().with(item -> {
              });
    }

}
