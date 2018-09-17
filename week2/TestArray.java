public class TestArray {
    public static void main(String args[]) {
       int [][]array;  // 创建一个空的二维int数组
       array=new int[5][]; // new一个5行的int数组
        for(int i=0;i<5;i++) 
          array[i]=new int[i]; // 对每一行再申请空间 分别为0、1、2、3、4
        for(int i=0;i<5;i++)
          for(int j=0;j<array[i].length;)           // 
          {                                         //
              array[i][j]=j;                        // 令array[i][j] = j
               System.out.print("   "+array[i][j]); // 输出a[i][j]
               ++j;                                 // j自增1
               if(j==(array[i].length))             // 若j等于该行array的长度，
               System.out.println();                // 输出\n
          }
    }
  }

