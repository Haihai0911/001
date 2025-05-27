import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.Font;

public class GameJFrame extends JFrame implements KeyListener {

    int[][] arr = new int[][]{
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };

    int score = 0;
    int scoreMax = 0;

    Font font1 = new Font("Arial", Font.BOLD, 20);
    Font font2 = new Font("宋体", Font.BOLD, 20);

    public GameJFrame() {
        initJFrame();
        initData();
        initImage();
        this.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(400,600);
        this.setTitle("2048");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    private void initImage() {
        this.getContentPane().removeAll();
        JLabel[][] count = new JLabel[4][4];
        JLabel[][] background = new JLabel[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel temp_count = new JLabel(""+arr[i][j]);
                temp_count.setFont(font1);
                count[i][j] = temp_count;
                JLabel temp_background = new JLabel(new ImageIcon("image\\" + arr[i][j] + ".png"));
                background[i][j] = temp_background;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                count[i][j].setBounds(i*100+30,j*100+15,50,50);
                background[i][j].setBounds(i*100,j*100,100,100);
                if(arr[i][j]!=0){
                    this.getContentPane().add(count[i][j]);
                    this.getContentPane().add(background[i][j]);
                }
            }
        }
        JLabel scoreLabel = new JLabel("分数："+score);
        scoreLabel.setFont(font2);
        scoreLabel.setBounds(50,420,500,200);
        this.getContentPane().add(scoreLabel);
        JLabel scoreMaxLabel = new JLabel("最高分："+scoreMax);
        scoreMaxLabel.setFont(font2);
        scoreMaxLabel.setBounds(225,420,500,200);
        this.getContentPane().add(scoreMaxLabel);
        this.getContentPane().repaint();
    }

    private void initData() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = 0;
            }
        }
        Random rand = new Random();
        int r1 = rand.nextInt(16);
        while(arr[r1/4][r1%4]!=0) {
            r1 = rand.nextInt(16);
        }
        arr[r1/4][r1%4]=2;
        int r2 = rand.nextInt(16);
        while(arr[r2/4][r2%4]!=0) {
            r2 = rand.nextInt(16);
        }
        arr[r2/4][r2%4]=2;
    }

    private void addData() {
        int flag = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(arr[i][j] == 0) {
                    flag = 1;
                }
            }
        }
        if(flag==1) {
            Random rand = new Random();
            int r = rand.nextInt(16);
            while(arr[r/4][r%4]!=0) {
                r = rand.nextInt(16);
            }
            arr[r/4][r%4]=2;
        }

    }

    private void DownChange() {
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j >= 1; j--) {
                if(arr[i][j]==0) {
                    arr[i][j]=arr[i][j-1];
                    arr[i][j-1]=0;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j >= 1; j--) {
                if(arr[i][j]==0) {
                    arr[i][j]=arr[i][j-1];
                    arr[i][j-1]=0;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j >= 1; j--) {
                if(arr[i][j]==0) {
                    arr[i][j]=arr[i][j-1];
                    arr[i][j-1]=0;
                }
            }
        }
    }

    private void UpChange() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[i][j]==0) {
                    arr[i][j]=arr[i][j+1];
                    arr[i][j+1]=0;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[i][j]==0) {
                    arr[i][j]=arr[i][j+1];
                    arr[i][j+1]=0;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[i][j]==0) {
                    arr[i][j]=arr[i][j+1];
                    arr[i][j+1]=0;
                }
            }
        }
    }

    private void LeftChange() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[j][i]==0) {
                    arr[j][i]=arr[j+1][i];
                    arr[j+1][i]=0;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[j][i]==0) {
                    arr[j][i]=arr[j+1][i];
                    arr[j+1][i]=0;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[j][i]==0) {
                    arr[j][i]=arr[j+1][i];
                    arr[j+1][i]=0;
                }
            }
        }
    }

    private void RightChange() {
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j >=1; j--) {
                if(arr[j][i]==0) {
                    arr[j][i]=arr[j-1][i];
                    arr[j-1][i]=0;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j >=1; j--) {
                if(arr[j][i]==0) {
                    arr[j][i]=arr[j-1][i];
                    arr[j-1][i]=0;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j >=1; j--) {
                if(arr[j][i]==0) {
                    arr[j][i]=arr[j-1][i];
                    arr[j-1][i]=0;
                }
            }
        }
    }

    private void DownAdd() {
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j >= 1; j--) {
                if(arr[i][j]==arr[i][j-1]) {
                    arr[i][j]*=2;
                    arr[i][j-1]=0;
                    score+=arr[i][j];
                }
            }
        }
    }

    private void UpAdd() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[i][j]==arr[i][j+1]) {
                    arr[i][j]*=2;
                    arr[i][j+1]=0;
                    score+=arr[i][j];
                }
            }
        }
    }

    private void LeftAdd() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[j][i]==arr[j+1][i]) {
                    arr[j][i]*=2;
                    arr[j+1][i]=0;
                    score+=arr[j][i];
                }
            }
        }
    }

    private void RightAdd() {
        for(int i = 0; i < 4; i++) {
            for(int j = 3; j >= 1; j--) {
                if(arr[j][i]==arr[j-1][i]) {
                    arr[j][i]*=2;
                    arr[j-1][i]=0;
                    score+=arr[j][i];
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 83) {
            DownChange();
            DownAdd();
            DownChange();
            if(ifLose()) {
                initData();
                initImage();
            }
            else {
                addData();
                initImage();
            }
        }
        else if(code == 87) {
            UpChange();
            UpAdd();
            UpChange();
            if(ifLose()) {
                initData();
                initImage();
            }
            else {
                addData();
                initImage();
            }
        }
        else if(code == 65) {
            LeftChange();
            LeftAdd();
            LeftChange();
            if(ifLose()) {
                initData();
                initImage();
            }
            else {
                addData();
                initImage();
            }
        }
        else if(code == 68) {
            RightChange();
            RightAdd();
            RightChange();
            if(ifLose()) {
                initData();
                initImage();
            }
            else {
                addData();
                initImage();
            }
        }
        else if(code == 67) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = 128;
                }
            }
            initImage();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public boolean ifLose() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(arr[i][j]==0) {
                    return false;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    return false;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    return false;
                }
            }
        }
        if(score > scoreMax) {
            scoreMax = score;
            score = 0;
        }
        return true;
    }


}
