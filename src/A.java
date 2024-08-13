import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            // 2차원 배열 크기 설정
            int N = Integer.parseInt(br.readLine());
            int size = N;
            int[][] arr = new int[size][size];
            // 2차원 배열의 좌표 값 설정
            int x = 0;
            int y = 0;
            // 2차원 배열 좌표에 해당하는 값 설정
            int num = 1;
            // 직선에 값 대입하는 횟수 확인
            int count = 0;

            sb.append("#" + (i + 1) + " \n");

            for(int j = 0; j < 2 * N - 1; j++) {
                switch(j % 4) {
                    case 0:
                        if(j == 0) {
                            for(int k = 0; k < size; k++) {
                                arr[y][x] = num;
                                x++;
                                num++;
                            }
                            x--;
                            y++;
                            size--;
                            break;
                        }
                        if(count == 2) {
                            count = 0;
                            size--;
                        }

                        for(int k = 0; k < size; k++) {
                            arr[y][x] = num;
                            x++;
                            num++;
                        }
                        x--;
                        y++;
                        count++;
                        break;
                    case 1:
                        if(count == 2) {
                            count = 0;
                            size--;
                        }
                        for(int k = 0; k < size; k++) {
                            arr[y][x] = num;
                            y++;
                            num++;
                        }
                        x--;
                        y--;
                        count++;
                        break;
                    case 2:
                        if(count == 2) {
                            count = 0;
                            size--;
                        }
                        for(int k = 0; k < size; k++) {
                            arr[y][x] = num;
                            x--;
                            num++;
                        }
                        x++;
                        y--;
                        count++;
                        break;
                    case 3:
                        if(count == 2) {
                            count = 0;
                            size--;
                        }
                        for(int k = 0; k < size; k++) {
                            arr[y][x] = num;
                            y--;
                            num++;
                        }
                        x++;;
                        y++;
                        count++;
                        break;
                }
            }

            for(int j = 0; j < arr.length; j++) {
                for(int k = 0; k < arr.length; k++) {
                    sb.append(arr[j][k] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
}
