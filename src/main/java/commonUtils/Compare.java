package commonUtils;

import java.util.HashSet;
import java.util.Set;

public class Compare {

    /**
     *
     * @param arr1 待比较的String[]
     * @param arr2 待比较的String[]
     * @param anys Set<String>, 可以代表任何字符串的字符串的集合
     * @return
     */
    public static boolean isTwoArrayEquals( String[] arr1, String[] arr2, Set<String> anys){

        if(arr1.length!=arr2.length){
            return false;
        }else{
            for(int i=0;i<arr1.length;i++){
                if(!arr1[i].equals(arr2[i]) && !anys.contains(arr1[i]) && !anys.contains(arr2[i]))
                    return false;
            }
        }
        return true;
    }

    public static boolean isTwoArrayEquals(String[] arr1, String[] arr2, String any){
        Set<String> anys = new HashSet<String>();
        anys.add(any);
        return isTwoArrayEquals(arr1,arr2,anys);
    }

    public static boolean isTwoArrayEquals(String[] arr1, String[] arr2){
        return arr1.equals(arr2);
    }

}
