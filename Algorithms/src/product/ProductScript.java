package product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductScript {

    public static void main(String[] args) {
        ProductScript ps = new ProductScript();
        ps.launch();
    }

    private void launch() {
        List<String> l1 = Arrays.asList("Hello","World");
        List<String> l2 = Arrays.asList("Bonjour", "monde");
        List<String> l3 = Arrays.asList("Hallo", "Welt");
        List<List<String>> masterList = new ArrayList<>();
        masterList.add(l1);
        masterList.add(l2);
        masterList.add(l3);

        System.out.println(Product.product2(masterList));

    }
}
