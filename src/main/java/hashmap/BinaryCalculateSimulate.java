package hashmap;

/**
 * 模拟java的二进制运算
 */
public class BinaryCalculateSimulate {

    public static void main(String[] args) {
        //Test, simulate hashmap calculate hashcode process~
        int hash1 = 86311884;
        int hash2 = 0;
        String binary1 = ConvertBinary.decimalToBinaryByRem2(hash1);
        String binary2 = ConvertBinary.decimalToBinaryByRem2(hash2);
        String xor = XOR(binary1, binary2);
        System.out.println("binaryXOR: " + xor);
        int xorNormal = (hash1 ^ hash2);
        System.out.println("by XOR ^ normal: " + xorNormal);
        String moveR20 = unsignedRightMove(xor, 20);
        System.out.println("move right 20: " + moveR20 + " ,十进制是： " + ConvertBinary.binaryToDecimal(moveR20));
        int moveR20Normal = xorNormal >>> 20;
        System.out.println("move right 20 by >>> normal: " + moveR20Normal);
        String moveR12 = unsignedRightMove(xor, 12);
        System.out.println("move right 12: " + moveR12 + " ,十进制是： " + ConvertBinary.binaryToDecimal(moveR12));
        int moveR12Normal = xorNormal >>> 12;
        System.out.println("move right 12 by >>> normal: " + moveR12Normal);
        String temp1 = XOR(moveR20, moveR12);
        System.out.println("xor temp1: " + temp1 + " ,十进制是： " + ConvertBinary.binaryToDecimal(temp1));
        int temp1Normal = moveR20Normal ^ moveR12Normal;
        System.out.println("xor temp1 by XOR ^ normal: " + temp1Normal + " ,二进制是： " + ConvertBinary.decimalToBinaryByRem2(temp1Normal));
        String temp2 = XOR(xor, temp1);
        System.out.println("xor temp2: " + temp2 + " ,十进制是： " + ConvertBinary.binaryToDecimal(temp2));
        int temp2Normal = xorNormal ^ temp1Normal;
        System.out.println("xor temp2 by XOR ^ normal: " + temp2Normal + " ,二进制是： " + ConvertBinary.decimalToBinaryByRem2(temp2Normal));
        String simulateCalculateResult = XOR(XOR(temp2, unsignedRightMove(temp2, 7)), unsignedRightMove(temp2, 4));
        System.out.println("calculate hash result by simulate method is: " + simulateCalculateResult + " ,十进制是： " + ConvertBinary.binaryToDecimal(simulateCalculateResult));
        int normalCalculateResult = temp2Normal ^ (temp2Normal >>> 7) ^ (temp2Normal >>> 4);
        System.out.println("calculate hash result by normal original way is: " + normalCalculateResult + " ,二进制是： " + ConvertBinary.decimalToBinaryByRem2(normalCalculateResult));
    }

//    public static void main(String[] args) {
//        //Test xor, pass!
//        int a = 82;
//        int b = 21072;
//        System.out.println("a binary string is: " + ConvertBinary.decimalToBinary(a) + " , b binary string is: " + ConvertBinary.decimalToBinary(b));
//        System.out.println("a binary string is: ByRem2 " + ConvertBinary.decimalToBinaryByRem2(a) + " , b binary string is: ByRem2 " + ConvertBinary.decimalToBinaryByRem2(b));
//        System.out.println("^ normal: " + (a ^ b) + " , binary is: " + ConvertBinary.decimalToBinary((a ^ b)));
//        String xor = XOR(ConvertBinary.decimalToBinary(a), ConvertBinary.decimalToBinary(b));
//        System.out.println("oxr by method: " + xor + " , decimal is: " + ConvertBinary.binaryToDecimal(xor));
//    }
    /**
     * a binary string is: 1010010 , b binary string is: 101001001010000
     * ^ normal: 20994 , binary is: 101001000000010
     *
     * 根据上面 ^ 异或结果得出结论：
     * java的异或，如果两个值的二进制长度不一样，则低位取相同长度对齐，按位异或，高位保留
     */


    /**
     * 模拟二进制的异或运算，输入需要都是二进制的string表示值
     *
     * @param binaryVal1
     * @param binaryVal2
     * @return
     */
    public static String XOR(String binaryVal1, String binaryVal2) {
        if (binaryVal1 == null || "".equals(binaryVal1.trim())) {
            throw new RuntimeException("binaryVal1 cannot be null or empty!");
        }
        if (binaryVal2 == null || "".equals(binaryVal2.trim())) {
            throw new RuntimeException("binaryVal2 cannot be null or empty!");
        }
        char[] cBin1 = binaryVal1.toCharArray();
        char[] cBin2 = binaryVal2.toCharArray();
        for (char c : cBin1) {
            //TODO char的判断不能用equals，即使写成"0".equals(c)也不行，因为编译是不报错，但是判断总是false，尴尬不=。=
            if (c != '0' && c != '1') {
                throw new RuntimeException("binaryVal1 every character must be 0 or 1 !");
            }
        }
        for (char c : cBin2) {
            if (c != '0' && c != '1') {
                throw new RuntimeException("binaryVal2 every character must be 0 or 1 !");
            }
        }

        String highPositionBinary = "";
        String oxrBin1 = "";
        String oxrBin2 = "";
        //截取长处来的位数，低位留作异或的按位计算输入值
        if (binaryVal1.length() == binaryVal2.length()) {
            //高位为空
            oxrBin1 = binaryVal1;
            oxrBin2 = binaryVal2;
        } else if (binaryVal1.length() > binaryVal2.length()) {
            highPositionBinary = binaryVal1.substring(0, (binaryVal1.length() - binaryVal2.length()));
            oxrBin1 = binaryVal1.substring((binaryVal1.length() - binaryVal2.length()), binaryVal1.length());
            oxrBin2 = binaryVal2;
        } else {
            highPositionBinary = binaryVal2.substring(0, (binaryVal2.length() - binaryVal1.length()));
            oxrBin1 = binaryVal1;
            //TODO 易错：又错了，begin和end都不需要减1，又又又又错了=。=，也是服了，易考易错，靠，记！！！
            oxrBin2 = binaryVal2.substring((binaryVal2.length() - binaryVal1.length()), binaryVal2.length());
        }
        //System.out.println("highPositionBinary: " + highPositionBinary);
        //System.out.println("oxrBin1: " + oxrBin1);
        //System.out.println("oxrBin2: " + oxrBin2);
        StringBuffer result = new StringBuffer();
        //高位直接保留在结果里
        result.append(highPositionBinary);
        //低位按位异或
        for (int i = 0; i < oxrBin1.length(); i++) {
            //如果两个值不相同，则异或结果为1。如果两个值相同，异或结果为0。
            if (oxrBin1.charAt(i) == oxrBin2.charAt(i)) {
                result.append("0");
            } else {
                result.append("1");
            }
        }
        //结果是：高位保留+低位异或 的结果
        return result.toString();
    }


    /**
     * 模拟二进制无符号右移
     *
     * @return
     */
    public static String unsignedRightMove(String binary, int move) {
        if (move > binary.length()) {
            throw new RuntimeException("can not move right longer than length!");
        } else {
            //TODO 易错：这里容易把endIndex多减了1，或者beginIndex没有减1，jdk的脑残设置，MMP
            return binary.substring(0, binary.length() - move);//substring的脑残index设置=。=
        }
    }


}
