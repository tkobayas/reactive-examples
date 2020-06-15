package quickstart.basic;

import java.util.List;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class FlatMap {

    public static void main(String[] args) {
        
        Uni<Integer> uni = Uni.createFrom().item(1);

        Multi<Integer> multi = Multi.createFrom().items(1, 2, 3);
        
        int result = uni
                .map(i -> i + 1)
                .await().indefinitely();
        
        System.out.println(result);

        int result2 = uni
                .flatMap(i -> Uni.createFrom().item(i + 1))
                .await().indefinitely();
        
        System.out.println(result2);


        List<Integer> list = multi
                .map(i -> i + 1)
                .collectItems().asList()
                .await().indefinitely();
        
        System.out.println(list);


        List<Integer> list2 = multi
                .flatMap(i -> Multi.createFrom().items(i, i))
                .collectItems().asList()
                .await().indefinitely();
        
        System.out.println(list2);


        List<Integer> list3 = multi
                .concatMap(i -> Multi.createFrom().items(i, i))
                .collectItems().asList()
                .await().indefinitely();

        System.out.println(list3);

    }

}
