import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        int testCase = 1;
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N]; // 2차원 배열 선언
            int x = 0, y = 0, num = 1;
            int direction = 0; // 0: 우, 1: 하, 2: 좌, 3: 상
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};


            while (num <= N * N) {
                arr[x][y] = num++;
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                // 경계 검사 및 이미 채워진 칸 확인
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {
                    direction = (direction + 1) % 4; // 방향 전환
                    nx = x + dx[direction];
                    ny = y + dy[direction];
                }

                x = nx;
                y = ny;
            }
            sb.append("#" + testCase++ + "\n");

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    sb.append(arr[j][k] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
