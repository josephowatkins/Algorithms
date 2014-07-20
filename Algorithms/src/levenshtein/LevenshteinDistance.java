package levenshtein;

public class LevenshteinDistance {
    /**
     * Function to find the minimum of 3 values
     */
    public int min(int a, int b,int c){
        int min = a;
        if(b < a){
            min = b;
        }
        if (c < b){
            min = c;
        }
        return min;
    }

    public int[][] calculateDistance(String s1, String s2){
        //create array to hold values and store commonly used variables;
        int len1 = s1.length() + 1;
        int len2 = s2.length() + 1;

        int[][] m = new int[len1][len2];


        for (int i = 1; i < len1; i++){
            m[i][0] = i;
        }
        for (int i = 1; i < len2; i++ ){
            m[0][i] = i;
        }

        for (int i = 1; i < len1; i++){
            for (int j = 1; j < len2; j++){

                //remember to use i-1 and j-1 in charAt() BECAUSE a String is a 0 based char array!!
                int x = m[i-1][j-1] + ((s1.charAt(i-1) == s2.charAt(j-1)) ? 0 : 1);

                // only a MAXIMIUM of 1 edit away from previous squares minimum edit distances - sometimes close (see above)
                int y = m[i-1][j] + 1;
                int z = m[i][j-1] + 1;

                m[i][j] = min(x,y,z);
            }
        }


        return m;
    }

    public void printPretty(int[][] a){
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

}