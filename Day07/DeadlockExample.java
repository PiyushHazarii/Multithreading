class Pen {
    public void writeWithPenAndPaper(Paper paper) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " locked Pen");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() + " locked Paper");
            }
        }
    }
}

class Paper {
    public void writeWithPaperAndPen(Pen pen) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " locked Paper");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (pen) {
                System.out.println(Thread.currentThread().getName() + " locked Pen");
            }
        }
    }
}

class Task1 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper); // thread1 locks pen and tries to lock paper
    }
}

class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        paper.writeWithPaperAndPen(pen); // thread2 locks paper and tries to lock pen
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread thread1 = new Thread(new Task1(pen, paper), "Thread-1");
        Thread thread2 = new Thread(new Task2(pen, paper), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
 
