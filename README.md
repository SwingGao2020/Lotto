
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

>>Random 42 (int)numbers and add 6 (int)numbers to HashSet.

```java    
    private static int ballnumber;
    private static Set balllist;
    private Iterator ball;
    private StringBuilder sb;
    
    public void NumberRandom() {
        balllist.clear();
        while (true) {
            ballnumber = (int) (Math.random() * 42 + 1);
            balllist.add(ballnumber);
            if (balllist.size() == 6) {
                break;
            }
        }
    }```

