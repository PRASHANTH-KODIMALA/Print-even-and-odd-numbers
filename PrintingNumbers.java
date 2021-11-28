// Print even and odd numbers in increasing order using two threads in Java

public class PrintingNumbers {
	int counter = 1;
	static int N;
	public void printOddNumber(){
		synchronized (this){
			while (counter < N) {
				while (counter % 2 == 0) {
					try {
						wait();
					}
					catch (
						InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(counter + " ");
				counter++;
				notify();
			}
		}
	}
	public void printEvenNumber(){
		synchronized (this){
			while (counter < N) {
				while (counter % 2 == 1) {
					try {
						wait();
					}
					catch (
						InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(counter + " ");
				counter++;
				notify();
			}
		}
	}
	public static void main(String[] args){
		N = 10;
		PrintingNumbers pn = new PrintingNumbers();
		Thread t1 = new Thread(new Runnable() {
			public void run(){
				pn.printEvenNumber();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run(){
				pn.printOddNumber();
			}
		});

		t1.start();
		t2.start();
	}
}
