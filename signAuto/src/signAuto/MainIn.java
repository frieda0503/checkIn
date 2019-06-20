package signAuto;

public class MainIn {

	public static void main(String args[]) {
		CheckInOutMethod check = new CheckInOutMethod();
//		check.checkInAtMorning();
		System.out.println("CheckIn Start");
		check.open();
		check.signIn(args[0],args[1]);
		check.checkIn();
		check.wait100Secs();
		check.logOut();
		check.wait100Secs();
		check.closeWindow();

		System.out.println("CheckIn Finish");
	}
}
