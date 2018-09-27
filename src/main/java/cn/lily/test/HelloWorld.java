package cn.lily.test;

public class HelloWorld {

    public  static  void permutation(char[] pStr){
        if (pStr == null || pStr.length < 1){
            return;
        }
        permutationCore(pStr, 0, pStr.length -1);
    }
    public  static  void permutationCore(char[] pStr, int begin, int tLength){
        if (begin == tLength){
            System.out.println(new String(pStr).substring(0,begin));
        } else {
            for (int i = begin; i < pStr.length; i++){
                if (begin !=  i && pStr[begin] == pStr[i]){
                    continue;
                }
                char temp = pStr[begin];
                pStr[begin] = pStr[i];
                pStr[i] = temp;
                permutationCore(pStr, begin + 1, tLength);
                pStr[i] =pStr[begin];
                pStr[begin] = temp;
            }
        }
    }
    public static  void main(String[] arg){
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
      //  permutation(c2);
    }
}
