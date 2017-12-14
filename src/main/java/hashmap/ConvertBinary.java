package hashmap;

public class ConvertBinary {

    /**
     * 使用int除以2取余，把十进制int转换为二进制形式string
     *
     * @param n
     * @return
     */
    public static String decimalToBinaryByRem2(int n) {
        String str = "";
        if (n != 0) {
            while (n != 0) {
                str = n % 2 + str;
                n = n / 2;
            }
        } else {
            str = "0";
        }
        //System.out.println(str);
        return str;
    }

    public static String decimalToBinary(int n) {
        String bin = Integer.toBinaryString(n);
        return bin;
    }

    /**
     * 二进制转十进制
     *
     * @param binary
     * @return
     */
    public static String binaryToDecimal(String binary) {
        return Integer.valueOf(binary, 2).toString();
    }


}
