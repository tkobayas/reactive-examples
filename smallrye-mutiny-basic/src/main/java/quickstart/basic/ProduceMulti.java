package quickstart.basic;

import java.util.List;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class ProduceMulti {

    public static void main(String[] args) {
        
        Uni<Integer> uni = Uni.createFrom().item(1);

        Multi<Integer> multi = Multi.createFrom().items(1, 2, 3);
        
        int result = uni
                .onItem().apply(i -> i + 1)
                .await().indefinitely();

        int result2 = uni
                .onItem().produceUni(i -> Uni.createFrom().item(i + 1))
                .await().indefinitely();

        List<Integer> list = multi
                .onItem().apply(i -> i + 1)
                .collectItems().asList()
                .await().indefinitely();

        List<Integer> list2 = multi
                .onItem().produceMulti(i -> Multi.createFrom().items(i, i)).merge()
                .collectItems().asList()
                .await().indefinitely();

        List<Integer> list3 = multi
                .onItem().produceMulti(i -> Multi.createFrom().items(i, i)).concatenate()
                .collectItems().asList()
                .await().indefinitely();

        System.out.println(result);

        System.out.println(result2);

        System.out.println(list);

        System.out.println(list2);

        System.out.println(list3);

    }

}
