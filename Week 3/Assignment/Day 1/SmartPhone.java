package week3.day1;

	public class SmartPhone extends AndroidPhone {
		
		public void connectWhatsapp() {
		
		System.out.println("Connected Whatsapp");
		}
		public void takeVideo() {
			System.out.println(" child Taking video");

		}
		
		public static void main(String[] args) {
			
			SmartPhone sm = new SmartPhone();
			sm.sendMsg();
			sm.takeVideo();
			sm.connectWhatsapp();
			sm.saveContact();
			sm.makecall();
			
			
		}
	}