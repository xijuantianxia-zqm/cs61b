package Discussion3;

public class Arrays {
    public static int[] insert(int[] arr,int item,int position){
        int n = arr.length;

        int[] b = new int[n + 1];
        System.arraycopy(arr,0,b,0,position);
        b[position] = item;
        System.arraycopy(arr,position,b,position+1,n - position);

        return b;
    }

    public static void reverse(int[] arr){

        for(int i = 0;i < arr.length / 2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static int[] replicate(int[] arr){
        int sum = 0;
        for(int num:arr) sum += num;

        int[] res = new int[sum];
        int index = 0;
        for(int num:arr){
            int i = 0;
            while (i++ < num) res[index++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};

        int[] res = replicate(test);
        for(int num:res){
            System.out.println(num);
        }
    }
}
