package levenshtein;

public class LevenshteinDistance {

    public int calculateDistance(String s1, String s2) {
        int[][] result = calculateDistanceHelper(s1, s2);

        // get the bottom left square;
        int y = result.length - 1; // how many arrays are there? i.e. the depth / y
        int x = result[0].length - 1; // how long is each array? i.e. x

        return result[y][x];

    }

    public void printDistanceWithArray(String s1, String s2){

        int[][] a = calculateDistanceHelper(s1, s2);

        for (int i = 0; i < a.length; i++){
            String line = "";
            for (int j = 0; j < a[0].length; j++){
                line += a[i][j] + " ";
            }
            System.out.println(line);
        }
        int i = a.length -1;
        int j = a[0].length - 1;
        System.out.println("The Levenshtein Distance is " + a[i][j]);
    }

    /**
     * Private helper function. Returns an array that can either be printed or the
     * edit distance can be extracted from.
     * @param s1 String one
     * @param s2 String two
     * @return array of edit distances.
     */
    private int[][] calculateDistanceHelper(String s1, String s2){
        //create array to hold values and store commonly used variables;

        int totalRows = s1.length() + 1;
        int totalColumns = s2.length() + 1;

        int[][] m = new int[totalRows][totalColumns];


        for (int column = 1; column < totalColumns; column++){
            m[0][column] = column;
        }
        for (int row = 1; row < totalRows; row++ ){
            m[row][0] = row;
        }

        for (int row = 1; row < totalRows; row++){
            for (int column = 1; column < totalColumns; column++){

                //remember to use i-1 and j-1 in charAt() BECAUSE a String is a 0 based char array!!
                int x = m[row-1][column-1] + ((s1.charAt(row-1) == s2.charAt(column-1)) ? 0 : 1);

                // only a MAXIMIUM of 1 edit away from previous squares minimum edit distances - sometimes close (see above)
                int y = m[row-1][column] + 1;
                int z = m[row][column-1] + 1;

                m[row][column] = min(x,y,z);
            }
        }
        return m;
    }

    /**
     * Function to find the minimum of 3 values
     */
    public int min(int a, int b, int c){
        int min = a;
        if(b < a){
            min = b;
        }
        if (c < min){
            min = c;
        }
        return min;
    }

}