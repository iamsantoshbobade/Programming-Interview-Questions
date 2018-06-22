package code.arrays;

/**
 * Created by santoshbobade on 1/9/17.
 */
public class CommonElements {

    public  static  void  main(String args[]){
        int a[] = { 1, 2, 3, 4, 5, 6, 10, 20, 30, 40,45,100};
        int b[] = { 1,2, 5,6,7,8, 10,14,30,40,100,200};
        int first = 0, second = 0;
        while(first < a.length && second < b.length){
            if(a[first] == b[second]){
                System.out.print(a[first]+" ");
                first++;
                second++;
            }else if(a[first] < b[second])
                first++;
            else
                second++;

        }
    }
}
