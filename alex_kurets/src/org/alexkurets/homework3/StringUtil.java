package org.alexkurets.homework3;

import java.util.Arrays;

public class StringUtil {
    public static int searchSubstring(char[] str, char[]substr)
    {
        for(int i=0; i<str.length;i++)
        {
            if((str.length-i)<substr.length)
                return -1;

            if(str[i]==substr[0])
                if(eqArray(str,substr,i)==true)
                    return i;
        }

        return -1;
    }

    private static boolean eqArray(char[] arrGeneral, char[] arrIcon,int startIndex)
    {
        for(int i=0;i<arrIcon.length;i++)
        {
            if(arrGeneral[i+startIndex]!=arrIcon[i])
                return false;
        }
        return true;
    }
}
