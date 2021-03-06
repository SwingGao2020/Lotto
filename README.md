
Lotto
=
Android practice
-
* Math.random
* HashSet
* Iterator
* Handler
* Runnable
* Button invisible
<br>
<img  src="https://github.com/SwingGao2020/Lotto/blob/master/preview.jpg" width="600"/>
<br>

>Random 42 numbers and add 6 of them to HashSet.

```java    
    private static int ballnumber;
    private static Set balllist = new HashSet();
    
    public void NumberRandom() {
        balllist.clear();
        while (true) {
            ballnumber = (int) (Math.random() * 42 + 1);
            balllist.add(ballnumber);
            if (balllist.size() == 6) break;
        }
    }    
```    
>Iterate over a HashSet and set TextViews.

```java
    private Iterator ball;
    private static TextView notv;
    private static int notvid;
    private static int[] notvids;
    notvids = {R.id.ball01, R.id.ball02, R.id.ball03, R.id.ball04, R.id.ball05, R.id.ball06};
    private StringBuilder sb = new StringBuilder();
    
    public void Display() {
    ball = balllist.iterator();
    while (ball.hasNext()) { 
        int i = -1;
        i++;
        switch (i) {
            case 0: notvid = notvids[0]; settvno();
            case 1: notvid = notvids[1]; settvno();
            case 2: notvid = notvids[2]; settvno();
            case 3: notvid = notvids[3]; settvno();
            case 4: notvid = notvids[4]; settvno();
            case 5: notvid = notvids[5]; settvno();
            default: break;
            }
        }
    }   
    
    public void settvno() {
        sb.delete(0, sb.length());
        notv = findViewById(notvid);
        Object obj = ball.next();

        if (obj instanceof Integer) {
            if ((int) obj < 10) { sb.append("0").append(obj); } 
                           else { sb.append(obj); }
        }
        notv.setText(sb);
        notv.setBackgroundResource(R.drawable.cycle);
    }
```
>Create class that implements Runnable , then Handler to post.

```java
    private Handler handler = new Handler();
    private Runnable starttask = new Startno();
    private Runnable stoptask = new Stopno();

    private class Startno implements Runnable {        
        public void run() {
            NumberRandom();
            Display();
            handler.postDelayed(this, 20); 
        }
    }

    private class Stopno implements Runnable {        
        public void run() {
            handler.removeCallbacks(starttask);
        }
    }
```
>Button onClick.

```java
    private Button btnstart = findViewById(R.id.start);
    private Button btnstop = findViewById(R.id.stop); // invisible
    private Button btnclear = findViewById(R.id.clear); // Enabled(false);
    private GradientDrawable btncolor = (GradientDrawable) btnclear.getBackground();
                             btncolor.setColor(Color.parseColor("#aaaaaa"));
    
    public void Start(View view) {
        handler.post(starttask);
        btnstart.setVisibility(view.INVISIBLE);
        btnstop.setVisibility(view.VISIBLE);
    }

    public void Stop(View view) {
        handler.post(stoptask);
        btnstop.setVisibility(view.INVISIBLE);
        btnstart.setVisibility(view.VISIBLE);
        btnclear.setEnabled(true);
        btncolor.setColor(Color.parseColor("#3D998D"));
    }

    public void Clear(View view) {
        for(int i=0;i<6;i++){
            notv = findViewById(notvids[i]);
            notv.setText("");
            notv.setBackgroundResource(R.drawable.cycle02);
            btncolor.setColor(Color.parseColor("#aaaaaa"));
        }
    }

```
    

