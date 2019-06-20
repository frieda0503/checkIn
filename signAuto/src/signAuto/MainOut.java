package signAuto;

public class MainOut {

	public static void main(String args[]) {
		CheckInOutMethod check = new CheckInOutMethod();
//		check.checkOutAtNight();
		
		System.out.println("CheckOut Start");
		check.open();
		check.signIn(args[0],args[1]);
		check.checkOut();
		check.wait100Secs();
		check.logOut();
		check.wait100Secs();
		check.closeWindow();

		System.out.println("CheckOut Finish");
	}
}
