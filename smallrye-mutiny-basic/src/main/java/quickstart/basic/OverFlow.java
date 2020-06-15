package quickstart.basic;

import io.smallrye.mutiny.Multi;

public class OverFlow {

    public static void main(String[] args) {

        Multi<Integer> multi = Multi.createFrom().items(1, 2, 3, 4, 5, 6);
        
        Integer res1 = multi
                .onOverflow().buffer(5)
                .collectItems().first()
                .await().indefinitely();
        
        System.out.println(res1);

        Integer res2 = multi
                .onOverflow().dropPreviousItems()
                .collectItems().first()
                .await().indefinitely();

        System.out.println(res2);
    }

}
