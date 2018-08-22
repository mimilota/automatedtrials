package session_timer;
import org.junit.Test;

public class TF_MRGC_41_script {

	@Test
	public void tc_41and39() throws Throwable,InterruptedException {
		home_func pagina = new home_func ();
		pagina.openB();
		Thread.sleep(1000);
		pagina.login();
		Thread.sleep(300000);
		//pagina.confirmbutton();
		pagina.redirect();
		Thread.sleep(500);
		pagina.checkloadedpage();
		//pagina.closeB();
		
}
}
