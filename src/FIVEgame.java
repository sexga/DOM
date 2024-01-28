import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author:YWQ
 * @Date :2023/12/26 - 17:09
 * @Desc : NULL
 **/

package fivechessgame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;



    @SuppressWarnings("serial")
    public class MyChessFrame extends JFrame implements MouseListener {
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();        //得到电脑屏幕的高和宽
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        private int x = 0;
        private int y = 0;
        private int option = 1;                                //设置按钮功能的操作数，初始化为1，功能两人PK，置为2时，功能人机大战
        static boolean White = true;
        boolean canplay = false;                        //标志数
        String message = "白方先行";
        private static int flag;                        //标志数
        private int allchess[][] = new int [11][11];//0表示没棋子，1表示白棋，2表示黑棋

        String state = "五子棋规则：\n "
                + "1． 五子棋专用盘为 11条横线×11条竖线组成，交叉的每个点都可以行棋。\n"
                + " 2． 游戏分黑白两方，每局由规定白方先行。白方玩家移动鼠标在棋盘中击行棋。\n"
                + "3． 当白方行棋完毕，转由黑方行棋。游戏结束后黑白方互换颜色。\n"
                + "胜负判定： 某一方玩家最先在棋盘上形成横、竖、斜连成五连或长连。将获得胜利。\n";


        public  MyChessFrame() {
            this.setResizable(false);
            this.setVisible(true);                        //设置窗口
            this.setTitle("五子棋");                        //设置标题
            this.setSize(750, 470);                        //设置窗口大小
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);        //设置窗口关闭方式
            this.setLocation((int)(width-600)/2, (int)(height-300)/2);//使窗口居中
            this.addMouseListener(this);        //添加鼠标监听器
            Container ct = null;
            ct=this.getContentPane();

            getContentPane().setLayout(null);
            // 游戏说明按钮，按下可显示说明文档

            Button button_1 = new Button("游戏说明");
            button_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(getComponent(0),
                            state);
                }
            });
            button_1.setForeground(Color.BLACK);
            button_1.setBackground(new Color(0, 191, 255));
            button_1.setBounds(605, 241, 99, 35);
            getContentPane().add(button_1);
//                游戏说明按钮，按下可显示相关信息
            Button button_2 = new Button("关于");
            button_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(getComponent(0),
                            "作者：傅佳垚， 学号B14060303，制作时间：2016年8月26日11:58:21\n"
                                    +"添加人机大战功能时间：2016年11月28日09:59:14");
                }
            });
            button_2.setForeground(Color.BLACK);
            button_2.setBackground(new Color(0, 191, 255));
            button_2.setBounds(605, 299, 99, 35);
            getContentPane().add(button_2);
//                游戏说明按钮，按下可退出游戏
            Button button_3 = new Button("退出");
            button_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            button_3.setForeground(Color.BLACK);
            button_3.setBackground(new Color(0, 191, 255));
            button_3.setBounds(605, 353, 99, 35);
            getContentPane().add(button_3);

            Button button = new Button("重新开始");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int i=0; i<=10; i++){                        //重置棋盘
                        for (int j=0; j<=10; j++){
                            allchess[i][j] = 0;

                        }
                    }
                    canplay = true;
                    repaint();
                }
            });
            button.setBounds(605, 34, 99, 35);
            button.setForeground(Color.BLACK);
            button.setBackground(new Color(0, 191, 255));
            getContentPane().add(button);

            Button button_4 = new Button("两人PK");
            button_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int i=0; i<=10; i++){                        //重置棋盘
                        for (int j=0; j<=10; j++){
                            allchess[i][j] = 0;

                        }
                    }
                    canplay = true;
                    option = 1;
                    repaint();
                }
            });
            button_4.setForeground(Color.BLACK);
            button_4.setBackground(new Color(0, 191, 255));
            button_4.setBounds(605, 105, 99, 35);
            getContentPane().add(button_4);

            Button button_5 = new Button("人机大战");
            button_5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int i=0; i<=10; i++){                        //重置棋盘
                        for (int j=0; j<=10; j++){
                            allchess[i][j] = 0;

                        }
                    }
                    option = 2;
                    canplay = true;
                    repaint();
                }
            });
            button_5.setForeground(Color.BLACK);
            button_5.setBackground(new Color(0, 191, 255));
            button_5.setBounds(605, 180, 99, 35);
            getContentPane().add(button_5);

        }



        public void paint (Graphics g) {
            Image bimage = null;
            String str = "/images/background.jpg" ;
            bimage = new ImageIcon(this.getClass().getResource(str)).getImage();
            g.drawImage(bimage, 0, 0, this);
            g.setFont(new Font("楷体",Font.BOLD, 30));
            g.drawString("游戏信息:", 200, 75);
            g.drawString( message, 375, 75);
            for (int i=0;i<=10; i++){
                g.setColor(Color.white);
                g.drawLine(200, 100+i*30, 500, 100+i*30);//竖线
                g.drawLine(200+i*30, 100, 200+i*30, 400);//横线
            }

            x = x*30 + 200;
            y = y*30 + 100;
            for (int i=0; i<=10; i++){
                for (int j=0; j<=10; j++){
                    if (allchess[i][j] == 1){
                        g.setColor(Color.WHITE);
                        int ax = i*30 + 200;
                        int by = j*30 + 100;
                        g.fillOval(ax-7, by-7, 15, 15);                //画白棋

                    }
                    if (allchess[i][j] == 2){
                        g.setColor(Color.BLACK);
                        int ax = i*30 + 200;
                        int by = j*30 + 100;
                        g.fillOval(ax-7, by-7, 15, 15);                //画黑棋

                    }
                }
            }
        }
        @Override
        public void mouseClicked(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }@Override
        public void mouseExited(MouseEvent e) {
        }@Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            if (canplay){                                                                        //按下按钮时.置为true.可以进入一下内容
                if (x>=200 && x<=500 && y>=100 && y<=400){
                    x = (x-185)/30;                                                        //得到棋盘的坐标
                    y = (y-85)/30;
                    if(option==1){                                                //PK功能
                        Player player = new Player (allchess);
                        player.twoPlayer(x, y, White);

                        if (flag==1){
                            message = "轮到黑方";
                            flag = 0;                                //初始化静态变量flag的值
                        }else if(flag == 2){
                            message = "轮到白方";
                            flag = 0;
                        }else{
                            flag = 0;
                            JOptionPane.showMessageDialog(this, "当前位置已经有棋子，请重新落子！");
                        }
                    }
                    if(option==2){                                        //功能：人机大战
                        Computer com = new Computer(allchess);
                        com.ComputerPlayer(x, y, White);
                        message = "人机大战";
                        if (flag == 3){
                            flag = 0;
                            JOptionPane.showMessageDialog(this, "当前位置已经有棋子，请重新落子！");
                        }

                    }

                    if (isWin(x,y,allchess)){
                        if(allchess[x][y] == 1)
                            JOptionPane.showMessageDialog(this, "游戏结束！白方获胜！！！");
                        if(allchess[x][y] == 2)
                            JOptionPane.showMessageDialog(this, "游戏结束！黑方获胜！！！");
                        canplay = false;

                    }
                    this.repaint();
                }

            }

        }@Override
        public void mouseReleased(MouseEvent e) {
        }
        public static boolean isWin(int x, int y,int allchess[][]){
            int color = allchess[x][y];
            int count = 1;
            int i = 1;
            //判断x轴是否有5个相连的棋子
            while ( x+i < 11 && allchess[x+i][y]==color){
                count++;
                i++;
            }
            i = 1;
            while ( x-i >= 0 && allchess[x-i][y]==color ){
                count++;
                i++;
            }
            if (count >= 5){
                return true;
            }
            //判断y轴是否有5个相连的棋子
            count = 1;
            i = 1;
            while (y+i < 11 && allchess[x][y+i]==color){
                count++;
                i++;
            }
            i = 1;
            while ( y-i >= 0 && allchess[x][y-i]==color){
                count++;
                i++;
            }
            if (count >= 5){
                return true;
            }
            //判断直线y = x 上是否有5个相连的棋子
            count = 1;
            i = 1;
            while (x+i < 11 && y+i < 11 && allchess[x+i][y+i]==color  ){
                count++;
                i++;
            }
            i = 1;
            while ( x-i >= 0 && y-i >= 0 && allchess[x-i][y-i]==color){
                count++;
                i++;
            }
            if (count >= 5){
                return true;
            }
            //判断直线y = -x 上是否有5个相连的棋子
            count = 1;
            i = 1;
            while (x-i >= 0 && y+i < 11 && allchess[x-i][y+i]==color ){
                count++;
                i++;
            }
            i = 1;
            while ( x+i < 11 && y-i >= 0 && allchess[x+i][y-i]==color ){
                count++;
                i++;
            }
            if (count >= 5){
                return true;
            }
            return false;
        }

        public static String setMessage(int chessColor){
            String message = null;
            if (chessColor==1){
                message = "轮到黑方";
                return message;
            }else{
                message = "轮到白方";
                return message;
            }
        }
        public static void isWhite(boolean white){
            MyChessFrame.White = white;
        }
        public static void changeFlag(int f){
            flag = f;
        }
    }

