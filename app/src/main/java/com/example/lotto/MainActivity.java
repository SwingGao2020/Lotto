package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    // 亂數用
    private static int ballnumber; // 亂數取得的號碼
    private static Set balllist; // 用 HashSet 放亂數取得的號碼，裡面的數字才不會重複。
    private Iterator ball; // HashSet 取值要先轉 Iterator，才會出現 next()，才能取值。
    private StringBuilder sb; //若數字為個位數，則把數字轉成字串前面補零。
    // 放數字的 TextView
    private static TextView notv;  //TextView
    private static int notvid;  // TextView 的 id number
    private static int[] notvids = {R.id.ball01, R.id.ball02, R.id.ball03, R.id.ball04, R.id.ball05, R.id.ball06}; // id number 陣列
    // 按鈕
    private Button btnstart;
    private Button btnstop; // 這顆先隱藏 invisible

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        balllist = new HashSet();
        sb = new StringBuilder();
        btnstart = findViewById(R.id.start);
        btnstop = findViewById(R.id.stop);
    }

    //亂數取六個號碼放進 balllist 裡。
    public void NumberRandom() {
        balllist.clear(); // 先將之前的陣列內容全部清除。
        while (true) {
            ballnumber = (int) (Math.random() * 42 + 1);
            balllist.add(ballnumber);
            if (balllist.size() == 6) {
                break;
            }
        }
    }

    // 顯示結果。  取出 HashSet 的值，分別代入不同的 TextView。
    public void Display() {
        ball = balllist.iterator(); // HashSet 取值要先轉 Iterator，才會出現 next()，才能取值。
        while (ball.hasNext()) { // 假如還有下一個 (即 ball.hasNext 為 true)，就把下一個印出來。
            int i = -1;
            i++;
            switch (i) {
                case 0:
                    notvid = notvids[0];
                    settvno();
                case 1:
                    notvid = notvids[1];
                    settvno();
                case 2:
                    notvid = notvids[2];
                    settvno();
                case 3:
                    notvid = notvids[3];
                    settvno();
                case 4:
                    notvid = notvids[4];
                    settvno();
                case 5:
                    notvid = notvids[5];
                    settvno();
                default:
                    break;
            }
        }
    }

    //將資料填入 TextView。
    public void settvno() {
        sb.delete(0, sb.length()); //清除字串內容。
        notv = findViewById(notvid);
        Object obj = ball.next();

        if (obj instanceof Integer) {
            if ((int) obj < 10) {
                sb.append("0").append(obj);  //個位數前面補 0。
            } else {
                sb.append(obj);
            }
        }
        notv.setText(sb);
        notv.setBackgroundResource(R.drawable.cycle);
    }

    // Start 按鈕 , 按下後隱藏，並將 Stop 按鈕顯示出來。
    public void Start(View view) {
        handler.post(starttask);
        btnstart.setVisibility(view.INVISIBLE);
        btnstop.setVisibility(view.VISIBLE);
    }

    // Stop 按鈕 , 按下後隱藏，並將 Start 按鈕顯示出來。
    public void Stop(View view) {
        handler.post(stoptask);
        btnstop.setVisibility(view.INVISIBLE);
        btnstart.setVisibility(view.VISIBLE);
    }

    ////////////////////////// 下面是內部 class，設定 Runnable 使用 handler 播放與停止。

    private Handler handler = new Handler();
    private Runnable starttask = new Startno();
    private Runnable stoptask = new Stopno();

    private class Startno implements Runnable {
        @Override
        public void run() {
            NumberRandom();
            Display();
            handler.postDelayed(this, 20); //每 0.02 秒換一組。
        }
    }

    private class Stopno implements Runnable {
        @Override
        public void run() {
            handler.removeCallbacks(starttask);
        }
    }
}
