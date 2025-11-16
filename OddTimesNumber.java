/*
 *  01 所有数中，有两种数是奇数，其他都是偶数 求这两个奇数 （*位运算）
 * 设两种奇数为a,b。
 * 由异或运算法则：同0异1 得出 eor= a^b
 * 通过每个数的二进制最低位将数分为两组：1 or 0
 * 分析：a,b为不同值，则a,b不同时为0。令a,b的二进制最低位不同
 * 此时设 a,other1为一组，b,other2为一组
 * 另设一 eor',只异或其中一组，得eor'=a or b
 * 最后将 eor 异或 eor' 得 b or a
 */
public class OddTimesNumber{
    public static void printOddTimesNum2(int[] arr){
    int eor=0;
    for(int i=0;i<arr.length;i++){
        eor ^=arr[i];

    }
    //eor =a ^ b
    //eor != 0
    //eor二进制位上必然有一位是1

    int rightOne = eor&(~eor+1); //提取出最右的1
    int onlyOne=0;
    for(int cur:arr){
        if((cur&rightOne)==0){
            onlyOne ^=cur;
        }
    }
    System.out.println(onlyOne +" "+(eor^onlyOne));

}
    //测试方法
    public static void main(String[] args){
        int[] arr={1,1,2,2,3,4,4,5,3,6};
        printOddTimesNum2(arr); //输出：6，5
    }
}

