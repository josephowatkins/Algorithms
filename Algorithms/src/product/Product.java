package product;

import java.util.ArrayList;
import java.util.List;

public class Product {


    public static List<List<String>> product2(List<List<String>> input){

        // helper array to build results during each iteration
        List<List<String>> temp = new ArrayList<>();


        // Make ArrayList to hold results - and initialise
        List<List<String>> results = new ArrayList<>();
        for (String s : input.get(0)){
            List<String> l  = new ArrayList<>();
            l.add(s);
            results.add(l);
        }


        // do this process from 1 to input.size()
        for (int k = 1; k < input.size(); k++){

            // list we are currently adding to results
            List<String> current = input.get(k);

            // loop over results adding each result list + entry from current list to temp list
            for (List<String> partialList : results) {
                for (String element : current) {

                    // make new list to hold results
                    List<String> l = new ArrayList<>();

                    // add previous result list + new element to list
                    l.addAll(partialList);
                    l.add(element);

                    //add list to temp
                    temp.add(l);

                }
            }
            // set results = temp (which is really latest results)
            results = temp;
            // reset temp for building next result list
            temp = new ArrayList<>();

        }
        return results;
    }

}
