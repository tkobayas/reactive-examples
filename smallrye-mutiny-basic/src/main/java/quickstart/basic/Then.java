package quickstart.basic;

import java.util.concurrent.CompletableFuture;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class Then {

    public static void main(String[] args) {
        String result = Multi.createFrom().completionStage(CompletableFuture.supplyAsync(() -> 23))
                .then(self -> {
                    // Transform each item into a string of the item +1
                    return self
                            .onItem().apply(i -> i + 1)
                            .onItem().apply(i -> Integer.toString(i));
                })
                .then(self -> self
                        .onItem().invoke(item -> System.out.println("The item is " + item))
                        .collectItems().first())
                .then(self -> self.await().indefinitely());
        
        System.out.println(result);

    }

}
