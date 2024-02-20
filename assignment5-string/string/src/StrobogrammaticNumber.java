import java.util.ArrayList;

public class StrobogrammaticNumber {
    public ArrayList<String> findStrobogrammatic(int n){
        if(n < 1 || n > 14) throw new IllegalArgumentException("1 <= n <= 14");

        ArrayList<String> result = new ArrayList<>();

        // if n mods 2 equals to 2, the number could only be 0, 1, 8; otherwise,
        // all numbers appear in pairs, such as [0,0], [1,1], [8,8], [6,9], [9,6]
        if(n % 2 == 1){
            buildStrobogrammaticList(result, "0", n, 1);
            buildStrobogrammaticList(result, "1", n, 1);
            buildStrobogrammaticList(result, "8", n, 1);
        }else{
            buildStrobogrammaticList(result,"", n,0);
        }

        return result;
    }

    private void buildStrobogrammaticList
            (ArrayList<String> result, String input, int n, int len){
        // add final string of Strobogrammatic number to list once the length equals to n
        if(len == n){
            result.add(input);
        }else{
            // 0 pair could only be added up when n minus length larger than 2
            if(n - len > 2){
                buildStrobogrammaticList(result, "0"+input+"0", n, len+2);
            }
            buildStrobogrammaticList(result, "1"+input+"1", n, len+2);
            buildStrobogrammaticList(result, "6"+input+"9", n, len+2);
            buildStrobogrammaticList(result, "8"+input+"8", n, len+2);
            buildStrobogrammaticList(result, "9"+input+"6", n, len+2);
        }
    }
}
