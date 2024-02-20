public class Main {
    public static void main(String[] args){
        LongestSubstring p1 = new LongestSubstring();

        // Problem 1 ex 1:
        String s1 = "eceba";
        System.out.println("Input s = \"eceba\"");
        System.out.println("Output = " + p1.findLongestSubstring(s1));

        // Problem 1 ex 2:
        String s2 = "ccaabbb";
        System.out.println("Input: s = \"ccaabbb\"");
        System.out.println("Output = " + p1.findLongestSubstring(s2));


        StrobogrammaticNumber p2 = new StrobogrammaticNumber();
        // Problem 2 ex 1:
        int n1 = 2;
        System.out.println("Input: n = 2");
        System.out.println("Output = " + p2.findStrobogrammatic(n1));

        // Problem 2 ex 2:
        int n2 = 1;
        System.out.println("Input: n = 1");
        System.out.println("Output = " + p2.findStrobogrammatic(n2));

        // Problem 2 ex 3:
        int n3 = 3;
        System.out.println("Input: n = 3");
        System.out.println("Output = " + p2.findStrobogrammatic(n3));

        // Problem 2 ex 4:
        int n4 = 4;
        System.out.println("Input: n = 4");
        System.out.println("Output = " + p2.findStrobogrammatic(n4));
    }
}
