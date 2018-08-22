package session_timer;

import org.junit.Test;

public class TF_MRGC_32 {
	@Test
	public void tc_32() throws Throwable,InterruptedException {
		home_func pagina = new home_func ();
		pagina.openB();
		Thread.sleep(1000);
		pagina.login();
		pagina.timeperiodL();
		pagina.gotohome();
		Thread.sleep(300000);
		pagina.checkloadedpage();
		pagina.closeB();
}
}