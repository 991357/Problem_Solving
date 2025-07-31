import java.io.*;
import java.util.*;

// 순조부 -> 순열, 조합, 부분집합 -> DFS, BFS -> MST -> 다익스트라 -> KMP -> A형 준비 완료
// arr = {1,3,5}
// 순열 = {1,1,1}, {1,1,3} , {1,1,5}, {1,3,1} ..... {5,5,5} => 중복을 허용...
// 조합 = ex) arr 에서 2개씩 뽑은 값을 반환해주세요. => {1,1}, {1,3}, {1,5} ... {5,5} => 조건
// 부분집합 = 원본 배열의 요소로 만들 수 있는 모든 (부분)집합 == PowerSet
    // ex_ 만약에 선거구간을 나눠야돼요. A동, B동, C동... => 방법은? 모든 부분집합을 구해보면 알 수 있죠?
    // 1 3 5 , 13 5, 1 35, .....

// 위의 3가지 코드는 툭 치면 나와야해요.
// 매일 매일 재귀 한단계씩 나아갈껍니다. 재귀 첫번째 단계 - 순
/*
* 1. 중복을 허용하는 순열
*       {1,1,1} --- {5,5,5}  3^3갯수
*
* arr 기준으로 3중 for문을 돈다고 생각하세요.
*
* 2. 중복을 허용하지 않는 순열
*       {1,3,5}, {1,5,3}} --- {5,3,1} -> 3C2
*/

// 중복 허용 O 순열
public class Recursive01
{
    // 원본
    static int[] arr = {1,3,5};

    // 선택  1 -> sel[0], sel[1] 1 => .....
    static int[] sel = new int[arr.length];

    public static void main(String[] args) throws IOException
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        recursive(0);
    }

    private static void recursive(int idx)
    {
        // bases part -> 멈춰 !
        if(idx == arr.length)
        {
            System.out.println(Arrays.toString(sel));
            return;
        }

        // inductive part -> 다음 재귀 호출
        else
        {
            for(int i = 0; i < arr.length; i++)
            {
                sel[idx] = arr[i];
                recursive(idx + 1);
            }
        }
    }
}
