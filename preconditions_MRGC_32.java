package session_timer;

import org.junit.Test;

public class preconditions_MRGC_32 {

	@Test
	public void TC_32() throws Throwable,InterruptedException {
		admin_func page = new admin_func ();
		page.openB();
		page.login();
		page.opensettings();
		page.rsgaming();
		Thread.sleep(1000);
		page.delsessiontimer();
		Thread.sleep(500);
		page.checkWC();
		page.closeB();
}
}