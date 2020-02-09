
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

>Random 42 (int)numbers and add 6 (int)numbers to HashSet.

```java    
    private static int ballnumber;
    private static Set balllist;
    
    public void NumberRandom() {
        balllist.clear();
        while (true) {
            ballnumber = (int) (Math.random() * 42 + 1);
            balllist.add(ballnumber);
            if (balllist.size() == 6) break;
        }
    }    
```    
>
```java
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
```
    

