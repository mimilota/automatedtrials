package session_timer;
import org.junit.Test;


public class TF_MRGC_40_script {
	@Test
	public void Settings() throws Throwable,InterruptedException {
		admin_func page = new admin_func ();
		page.openB();
		Thread.sleep(500);
		page.login();
		page.opensettings();
		page.rsgaming();
		Thread.sleep(500);
		page.delsessiontimer();
		Thread.sleep(1000);
		page.checkWC();
		page.closeB();
	}
}