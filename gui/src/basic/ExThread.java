package basic;

class PlayGame extends Thread {
	private void PlayGame() {

	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Ω««‡¡ﬂ");
			try {
				sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

class PlayMusic implements Runnable {
	boolean play;

	@Override
	public void run() {
		play=true;
		while (play) {
			System.out.println("¿Ωæ«»Â∏ß");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
}

public class ExThread {
	public static void main(String[] args) {
		PlayGame play = new PlayGame();
//		play.start();
//		for (int i = 0; i <10; i++) {
//			System.out.println(i);
//			if (i==8) {
//				System.out.println("E");
//				play.stop();
//			}
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//		}
		Runnable music=new PlayMusic();
		Thread thread =new Thread(music);
		thread.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if (i==7) {
				System.out.println("§∑§∑");
				PlayMusic stop =(PlayMusic) music;
				stop.play=false;
 			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
	}
}
