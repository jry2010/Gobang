import java.util.Arrays;
import java.util.Scanner;

public class Gobang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Winner = 0;
        int a = 0, b = 0;
        int stepCountPlayer = 0;
        int stepCountRobot = 0;
        int inputX = 0, inputY = 0;
        long robotThinkingStart = 0, robotThinkingFinish = 0;
        boolean robotDrop = false;
        boolean xyCheck = false;
        boolean drop = false;
        int[][] robotScore = new int[50][50];
        int[][] xy = new int[50][50];
        while (true) {
            for (int i = 14; i > -1; i--) {
                for (int j = 0; j < 15; j++) { //i是纵坐标，j是横坐标
                    int it = i + 4;
                    int jt = j + 4;
                    switch (xy[jt][it]) {
                        case 2 -> {
                            if (jt == 4) {
                                if (it >= 14) {
                                    System.out.print(" " + i + "  " + "▲");
                                } else System.out.print(" " + i + "   " + "▲");
                            } else System.out.print("▲");
                        }
                        case 1 -> {
                            if (jt == 4) {
                                if (it >= 14) {
                                    System.out.print(" " + i + "  " + "□");
                                } else System.out.print(" " + i + "   " + "□");
                            } else System.out.print("□");
                        }
                        default -> {
                            if (j == 0) {
                                if (i >= 10) {
                                    System.out.print(" " + i + "  ─|");
                                } else System.out.print(" " + i + "   ─|");
                            } else System.out.print("─|");
                        }
                    }
                }
                System.out.println();
            }
            System.out.println("      " + "0 1 2 3 4 5 6 7 8 9 A B C D E");
            System.out.println();
            if (xy[inputX][inputY] == 2 && xy[inputX + 1][inputY] == 2
                    && xy[inputX + 2][inputY] == 2 && xy[inputX + 3][inputY] == 2
                    && xy[inputX + 4][inputY] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX + 1][inputY] == 2
                            && xy[inputX + 2][inputY] == 2 && xy[inputX + 3][inputY] == 2
                            && xy[inputX - 1][inputY] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX + 1][inputY] == 2
                            && xy[inputX + 2][inputY] == 2 && xy[inputX - 1][inputY] == 2
                            && xy[inputX - 2][inputY] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX + 1][inputY] == 2
                            && xy[inputX - 1][inputY] == 2 && xy[inputX - 2][inputY] == 2
                            && xy[inputX - 3][inputY] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX - 1][inputY] == 2
                            && xy[inputX - 2][inputY] == 2 && xy[inputX - 3][inputY] == 2
                            && xy[inputX - 4][inputY] == 2 || //横坐标
                    xy[inputX][inputY] == 2 && xy[inputX][inputY + 1] == 2
                            && xy[inputX][inputY + 2] == 2 && xy[inputX][inputY + 3] == 2
                            && xy[inputX][inputY + 4] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX][inputY + 1] == 2
                            && xy[inputX][inputY + 2] == 2 && xy[inputX][inputY + 3] == 2
                            && xy[inputX][inputY - 1] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX][inputY + 1] == 2
                            && xy[inputX][inputY + 2] == 2 && xy[inputX][inputY - 1] == 2
                            && xy[inputX][inputY - 2] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX][inputY + 1] == 2
                            && xy[inputX][inputY - 1] == 2 && xy[inputX][inputY - 2] == 2
                            && xy[inputX][inputY - 3] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX][inputY - 1] == 2
                            && xy[inputX][inputY - 2] == 2 && xy[inputX][inputY - 3] == 2
                            && xy[inputX][inputY - 4] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX + 1][inputY + 1] == 2
                            && xy[inputX + 2][inputX + 2] == 2 && xy[inputX + 3][inputY + 3] == 2
                            && xy[inputX + 4][inputY + 4] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX + 1][inputY + 1] == 2
                            && xy[inputX + 2][inputY + 2] == 2 && xy[inputX + 3][inputY + 3] == 2
                            && xy[inputX - 1][inputY - 1] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX + 1][inputY + 1] == 2
                            && xy[inputX + 2][inputY + 2] == 2 && xy[inputX - 1][inputY - 1] == 2
                            && xy[inputX - 2][inputY - 2] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX + 1][inputY + 1] == 2
                            && xy[inputX - 1][inputY - 1] == 2 && xy[inputX - 2][inputY - 2] == 2
                            && xy[inputX - 3][inputY - 3] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX - 1][inputY - 1] == 2
                            && xy[inputX - 2][inputY - 2] == 2 && xy[inputX - 3][inputY - 3] == 2
                            && xy[inputX - 4][inputY - 4] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX - 1][inputY + 1] == 2
                            && xy[inputX - 2][inputY + 2] == 2 && xy[inputX - 3][inputY + 3] == 2
                            && xy[inputX - 4][inputY + 4] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX - 1][inputY + 1] == 2
                            && xy[inputX - 2][inputY + 2] == 2 && xy[inputX - 3][inputY + 3] == 2
                            && xy[inputX + 1][inputY - 1] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX - 1][inputY + 1] == 2
                            && xy[inputX - 2][inputY + 2] == 2 && xy[inputX + 1][inputY - 1] == 2
                            && xy[inputX + 2][inputY - 2] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX - 1][inputY + 1] == 2
                            && xy[inputX + 1][inputY - 1] == 2 && xy[inputX + 2][inputY - 2] == 2
                            && xy[inputX + 3][inputY - 3] == 2 ||
                    xy[inputX][inputY] == 2 && xy[inputX + 1][inputY - 1] == 2
                            && xy[inputX + 2][inputY - 2] == 2 && xy[inputX + 3][inputY - 3] == 2
                            && xy[inputX + 4][inputY - 4] == 2) {
                Winner = 2;
                break;
            }
            if (robotDrop && !xyCheck) {
                a -= 4;
                b -= 4;
                System.out.println("jrybot落子在" + "(" + a + ", " + b + ")  本次思考用时: " + (robotThinkingFinish - robotThinkingStart) + "毫秒");
                System.out.println("总步数: " + (stepCountRobot + stepCountPlayer));
                System.out.println();
            }
            if (xyCheck) {
                System.out.println("请重新输入x轴和y轴坐标:");
                System.out.println();
            } else {
                if (!drop) {
                    System.out.println("请输入x轴和y轴坐标(两坐标用空格隔开):");
                    System.out.println();
                } else {
                    System.out.println("请输入x轴和y轴坐标:");
                    System.out.println();
                }
            }
            drop = true;
            long playerThinkingStart = System.currentTimeMillis();
            inputX = sc.nextInt();
            inputY = sc.nextInt();
            long playerThinkingFinish = System.currentTimeMillis();
            long pp = playerThinkingFinish - playerThinkingStart;
            int pp_int = (int) (pp / 1000);
            int inputX_backup = inputX;
            int inputY_backup = inputY;
            inputX += 4;
            inputY += 4;
            System.out.println();
            if (inputX_backup <= 14 && inputY_backup <= 14 && xy[inputX][inputY] == 0) {
                xy[inputX][inputY] = 2; // 2:玩家 1:机器 0:空
                xyCheck = false;
                System.out.println("成功落子在坐标:" + "(" + inputX_backup + ", " + inputY_backup + ")  本次思考用时: " + pp_int + "秒");
                stepCountPlayer++;
                System.out.println("总步数: " + (stepCountPlayer + stepCountRobot));
            } else {
                if (inputX_backup > 14 || inputY_backup > 14) {
                    System.out.println("超出棋盘");
                    System.out.println();
                } else {
                    System.out.println("该坐标与其它棋子重合");
                    System.out.println();
                }
                xyCheck = true;
            }
            // 机器人模块起始位置
            robotThinkingStart = System.currentTimeMillis();
            for (int is = 0; is <= 14; is++) {
                for (int js = 0; js <= 14; js++) {
                    int i = is + 4;
                    int j = js + 4;
                    int[] temp = getInt(xy, i, j);
                    Arrays.sort(temp);
                    robotScore[i][j] = temp[3];
                }
            }
            if (!xyCheck) {
                int max = -1;
                int min = 100; // 100无特殊意义
                for (int i = 4; i < 19; i++) {
                    for (int j = 4; j < 19; j++) {
                        if (robotScore[i][j] > max && xy[i][j] == 0) {
                            max = robotScore[i][j];
                        }
                    }
                }
                for (int i = 4; i < 19; i++) {
                    for (int j = 4; j < 19; j++) {
                        if (robotScore[i][j] == max && min > i + j - inputX - inputY && xy[i][j] == 0) {
                            min = i + j - inputX - inputY;
                            if (min < 0) min *= -1;
                            a = i;
                            b = j;
                        }
                    }
                }
                xy[a][b] = 1;
                robotDrop = true;
                stepCountRobot++;
            }
            robotThinkingFinish = System.currentTimeMillis();
            // 机器人模块结束位置
            // 判定机器人输赢模块起始位置
            for (int X = 4; X <= 19; X++) {
                for (int Y = 4; Y <= 19; Y++) {
                    if (xy[X][Y] == 1 && xy[X + 1][Y] == 1
                            && xy[X + 2][Y] == 1 && xy[X + 3][Y] == 1
                            && xy[X + 4][Y] == 1 ||
                            xy[X][Y] == 1 && xy[X + 1][Y] == 1
                                    && xy[X + 2][Y] == 1 && xy[X + 3][Y] == 1
                                    && xy[X - 1][Y] == 1 ||
                            xy[X][Y] == 1 && xy[X + 1][Y] == 1
                                    && xy[X + 2][Y] == 1 && xy[X - 1][Y] == 1
                                    && xy[X - 2][Y] == 1 ||
                            xy[X][Y] == 1 && xy[X + 1][Y] == 1
                                    && xy[X - 1][Y] == 1 && xy[X - 2][Y] == 1
                                    && xy[X - 3][Y] == 1 ||
                            xy[X][Y] == 1 && xy[X - 1][Y] == 1
                                    && xy[X - 2][Y] == 1 && xy[X - 3][Y] == 1
                                    && xy[X - 4][Y] == 1 || //横坐标
                            xy[X][Y] == 1 && xy[X][Y + 1] == 1
                                    && xy[X][Y + 2] == 1 && xy[X][Y + 3] == 1
                                    && xy[X][Y + 4] == 1 ||
                            xy[X][Y] == 1 && xy[X][Y + 1] == 1
                                    && xy[X][Y + 2] == 1 && xy[X][Y + 3] == 1
                                    && xy[X][Y - 1] == 1 ||
                            xy[X][Y] == 1 && xy[X][Y + 1] == 1
                                    && xy[X][Y + 2] == 1 && xy[X][Y - 1] == 1
                                    && xy[X][Y - 2] == 1 ||
                            xy[X][Y] == 1 && xy[X][Y + 1] == 1
                                    && xy[X][Y - 1] == 1 && xy[X][Y - 2] == 1
                                    && xy[X][Y - 3] == 1 ||
                            xy[X][Y] == 1 && xy[X][Y - 1] == 1
                                    && xy[X][Y - 2] == 1 && xy[X][Y - 3] == 1
                                    && xy[X][Y - 4] == 1 ||
                            xy[X][Y] == 1 && xy[X + 1][Y + 1] == 1
                                    && xy[X + 2][X + 2] == 1 && xy[X + 3][Y + 3] == 1
                                    && xy[X + 4][Y + 4] == 1 ||
                            xy[X][Y] == 1 && xy[X + 1][Y + 1] == 1
                                    && xy[X + 2][Y + 2] == 1 && xy[X + 3][Y + 3] == 1
                                    && xy[X - 1][Y - 1] == 1 ||
                            xy[X][Y] == 1 && xy[X + 1][Y + 1] == 1
                                    && xy[X + 2][Y + 2] == 1 && xy[X - 1][Y - 1] == 1
                                    && xy[X - 2][Y - 2] == 1 ||
                            xy[X][Y] == 1 && xy[X + 1][Y + 1] == 1
                                    && xy[X - 1][Y - 1] == 1 && xy[X - 2][Y - 2] == 1
                                    && xy[X - 3][Y - 3] == 1 ||
                            xy[X][Y] == 1 && xy[X - 1][Y - 1] == 1
                                    && xy[X - 2][Y - 2] == 1 && xy[X - 3][Y - 3] == 1
                                    && xy[X - 4][Y - 4] == 1 ||
                            xy[X][Y] == 1 && xy[X - 1][Y + 1] == 1
                                    && xy[X - 2][Y + 2] == 1 && xy[X - 3][Y + 3] == 1
                                    && xy[X - 4][Y + 4] == 1 ||
                            xy[X][Y] == 1 && xy[X - 1][Y + 1] == 1
                                    && xy[X - 2][Y + 2] == 1 && xy[X - 3][Y + 3] == 1
                                    && xy[X + 1][Y - 1] == 1 ||
                            xy[X][Y] == 1 && xy[X - 1][Y + 1] == 1
                                    && xy[X - 2][Y + 2] == 1 && xy[X + 1][Y - 1] == 1
                                    && xy[X + 2][Y - 2] == 1 ||
                            xy[X][Y] == 1 && xy[X - 1][Y + 1] == 1
                                    && xy[X + 1][Y - 1] == 1 && xy[X + 2][Y - 2] == 1
                                    && xy[X + 3][Y - 3] == 1 ||
                            xy[X][Y] == 1 && xy[X + 1][Y - 1] == 1
                                    && xy[X + 2][Y - 2] == 1 && xy[X + 3][Y - 3] == 1
                                    && xy[X + 4][Y - 4] == 1) {
                        Winner = 1;
                        break;
                    }
                }
                if (Winner == 1) break;
            }
            if (Winner == 1) break;
            // 判定机器人输赢模块结束位置
        }
        if (Winner == 2) {
            System.out.println("玩家获胜");
        } else {
            System.out.println("机器人获胜");
        }
    }

    private static int[] getInt(int[][] xy, int i, int j) {
        int number_Of_Chess_Pieces_On_The_Line_Heng = 0;
        int number_Of_Chess_Pieces_On_The_Line_Shu = 0;
        int number_Of_Chess_Pieces_On_The_Line_ZSYX = 0;
        int number_Of_Chess_Pieces_On_The_Line_YSZX = 0;
        // ---------------------------------
        if (xy[i + 1][j] == 2) number_Of_Chess_Pieces_On_The_Line_Heng++;
        if (xy[i + 2][j] == 2) number_Of_Chess_Pieces_On_The_Line_Heng++;
        if (xy[i + 3][j] == 2) number_Of_Chess_Pieces_On_The_Line_Heng++;
        if (xy[i + 4][j] == 2) number_Of_Chess_Pieces_On_The_Line_Heng++;
        if (xy[i - 1][j] == 2) number_Of_Chess_Pieces_On_The_Line_Heng++;
        if (xy[i - 2][j] == 2) number_Of_Chess_Pieces_On_The_Line_Heng++;
        if (xy[i - 3][j] == 2) number_Of_Chess_Pieces_On_The_Line_Heng++;
        if (xy[i - 4][j] == 2) number_Of_Chess_Pieces_On_The_Line_Heng++;
        // ---------------------------------
        if (xy[i][j + 1] == 2) number_Of_Chess_Pieces_On_The_Line_Shu++;
        if (xy[i][j + 2] == 2) number_Of_Chess_Pieces_On_The_Line_Shu++;
        if (xy[i][j + 3] == 2) number_Of_Chess_Pieces_On_The_Line_Shu++;
        if (xy[i][j + 4] == 2) number_Of_Chess_Pieces_On_The_Line_Shu++;
        if (xy[i][j - 1] == 2) number_Of_Chess_Pieces_On_The_Line_Shu++;
        if (xy[i][j - 2] == 2) number_Of_Chess_Pieces_On_The_Line_Shu++;
        if (xy[i][j - 3] == 2) number_Of_Chess_Pieces_On_The_Line_Shu++;
        if (xy[i][j - 4] == 2) number_Of_Chess_Pieces_On_The_Line_Shu++;
        // ---------------------------------
        if (xy[i - 1][j + 1] == 2) number_Of_Chess_Pieces_On_The_Line_ZSYX++;
        if (xy[i - 2][j + 2] == 2) number_Of_Chess_Pieces_On_The_Line_ZSYX++;
        if (xy[i - 3][j + 3] == 2) number_Of_Chess_Pieces_On_The_Line_ZSYX++;
        if (xy[i - 4][j + 4] == 2) number_Of_Chess_Pieces_On_The_Line_ZSYX++;
        if (xy[i + 1][j - 1] == 2) number_Of_Chess_Pieces_On_The_Line_ZSYX++;
        if (xy[i + 2][j - 2] == 2) number_Of_Chess_Pieces_On_The_Line_ZSYX++;
        if (xy[i + 3][j - 3] == 2) number_Of_Chess_Pieces_On_The_Line_ZSYX++;
        if (xy[i + 4][j - 4] == 2) number_Of_Chess_Pieces_On_The_Line_ZSYX++;
        // ---------------------------------
        if (xy[i + 1][j + 1] == 2) number_Of_Chess_Pieces_On_The_Line_YSZX++;
        if (xy[i + 2][j + 2] == 2) number_Of_Chess_Pieces_On_The_Line_YSZX++;
        if (xy[i + 3][j + 3] == 2) number_Of_Chess_Pieces_On_The_Line_YSZX++;
        if (xy[i + 4][j + 4] == 2) number_Of_Chess_Pieces_On_The_Line_YSZX++;
        if (xy[i - 1][j - 1] == 2) number_Of_Chess_Pieces_On_The_Line_YSZX++;
        if (xy[i - 2][j - 2] == 2) number_Of_Chess_Pieces_On_The_Line_YSZX++;
        if (xy[i - 3][j - 3] == 2) number_Of_Chess_Pieces_On_The_Line_YSZX++;
        if (xy[i - 4][j - 4] == 2) number_Of_Chess_Pieces_On_The_Line_YSZX++;
        // ---------------------------------
        return new int[]{number_Of_Chess_Pieces_On_The_Line_Heng, number_Of_Chess_Pieces_On_The_Line_ZSYX,
                number_Of_Chess_Pieces_On_The_Line_Shu, number_Of_Chess_Pieces_On_The_Line_YSZX};
    }
}
