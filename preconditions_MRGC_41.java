package session_timer;

import org.junit.Test;

public class preconditions_MRGC_41 {

	@Test
	public void Settings() throws Throwable,InterruptedException {
		admin_func page = new admin_func ();
		page.openB();
		page.login();
		page.opensettings();
		page.rsgaming();
		//page.timeisflying("20");
		page.selectwcredirect();
		page.checkWC();
		page.closeB();
		
}
}