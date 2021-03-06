import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    static boolean[][] mag = new boolean[6][10];
    static void sol(int m,int r) {      //인자 : 돌릴 자석과, 돌릴방향
 
        if(r==1) {                      //시계방향으로 돌리는 경우 1
            if(m==1) {
                if(!check(mag[m][3],mag[m+1][7])) {
                    if(!check(mag[m+1][3],mag[m+2][7])) {
                        if(!check(mag[m+2][3],mag[m+3][7])) {
                            rotate_counterClock(m+3);
                        }
                        rotate_Clock(m+2);
                    }
                    rotate_counterClock(m+1);
                }
            }
            if(m==2) {
                if(!check(mag[m][7],mag[m-1][3])) rotate_counterClock(m-1);
                if(!check(mag[m+1][7],mag[m][3])) {
                    if(!check(mag[m+1][3],mag[m+2][7])) {
                        rotate_Clock(m+2);
                    }
                    rotate_counterClock(m+1);
                }
            }
            if(m==3) {
                if(!check(mag[m][3],mag[m+1][7])) rotate_counterClock(m+1);
                if(!check(mag[m-1][3],mag[m][7])) {
                    if(!check(mag[m-1][7],mag[m-2][3])) {
                        rotate_Clock(m-2);
                    }
                    rotate_counterClock(m-1);
                }
                 
            }
            if(m==4) {
                if(!check(mag[m][7],mag[m-1][3])) {
                    if(!check(mag[m-1][7],mag[m-2][3])) {
                        if(!check(mag[m-2][7],mag[m-3][3])) {
                            rotate_counterClock(m-3);
                        }
                        rotate_Clock(m-2);
                    }
                    rotate_counterClock(m-1);
                }
            }
            rotate_Clock(m);
        }
         
        else if(r==-1){                         //반시계 방향으로 -1
            if(m==1) {
                if(!check(mag[m][3],mag[m+1][7])) {
                    if(!check(mag[m+1][3],mag[m+2][7])) {
                        if(!check(mag[m+2][3],mag[m+3][7])) {
                            rotate_Clock(m+3);
                        }
                        rotate_counterClock(m+2);
                    }
                    rotate_Clock(m+1);
                }
            }
            if(m==2) {
                if(!check(mag[m][7],mag[m-1][3])) rotate_Clock(m-1);
                if(!check(mag[m+1][7],mag[m][3])) {
                    if(!check(mag[m+1][3],mag[m+2][7])) {
                        rotate_counterClock(m+2);
                    }
                    rotate_Clock(m+1);
                }
            }
            if(m==3) {
                if(!check(mag[m][3],mag[m+1][7])) rotate_Clock(m+1);
                if(!check(mag[m-1][3],mag[m][7])) {
                    if(!check(mag[m-1][7],mag[m-2][3])) {
                        rotate_counterClock(m-2);
                    }
                    rotate_Clock(m-1);
                }
                 
            }
            if(m==4) {
                if(!check(mag[m][7],mag[m-1][3])) {
                    if(!check(mag[m-1][7],mag[m-2][3])) {
                        if(!check(mag[m-2][7],mag[m-3][3])) {
                            rotate_Clock(m-3);
                        }
                        rotate_counterClock(m-2);
                    }
                    rotate_Clock(m-1);
                }
            }
            rotate_counterClock(m);
        }
        //돌림
    }
    static boolean check(boolean a,boolean b) {
        return (a==b)? true:false;
    }
    static void rotate_Clock(int m) {
        boolean a=mag[m][8];
        System.arraycopy(mag[m], 1, mag[m], 2, 7);
        mag[m][1]=a;
    }
    static void rotate_counterClock(int m) {
        boolean a=mag[m][1];
        System.arraycopy(mag[m], 2, mag[m], 1, 7);
        mag[m][8]=a;
    }
    public static void main(String args[]) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int T,K,score=0;
        T=scan.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            K=scan.nextInt();
            for(int j=1;j<5;j++) {
                for(int k=1;k<9;k++) {
                    int a = scan.nextInt();
                    if(a==1) mag[j][k]=true;
                }
            }
            for(int j=0;j<K;j++) {
                int magnetic=scan.nextInt();
                int rotate  = scan.nextInt();
                sol(magnetic,rotate);
            }
            if(mag[1][1]) score+=1;
            if(mag[2][1]) score+=2;
            if(mag[3][1]) score+=4;
            if(mag[4][1]) score+=8;
            System.out.println("#"+test_case+" "+score);
            score=0;
            mag = new boolean[6][10];
        }
    }
}
