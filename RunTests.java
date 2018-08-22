package session_timer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunTests {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TF_MRGC_54.class);
	     for (Failure failure : result.getFailures()) 
	         System.err.println(failure.toString());
	    
	     System.out.println();
	     System.out.println(result.wasSuccessful());
	     
	     Result result_40 = JUnitCore.runClasses(TF_MRGC_40.class);
	     for (Failure failure : result.getFailures()) 
	         System.err.println(failure.toString());
	   
	     System.out.println();
	     System.out.println(result.wasSuccessful());
	      
	     
	     Result result_preconditions_MRGC_41 = JUnitCore.runClasses(preconditions_MRGC_41.class);
	     for (Failure failure : result.getFailures()) 
	         System.err.println(failure.toString());
	   
	      System.out.println();
	     System.out.println(result.wasSuccessful());
	     
	     Result result_TF_MRGC_41_script = JUnitCore.runClasses(TF_MRGC_41_script.class);
	     for (Failure failure : result.getFailures()) 
	         System.err.println(failure.toString());
	   
	      System.out.println();
	     System.out.println(result.wasSuccessful());
	     
	     Result result_preconditions_MRGC_32 = JUnitCore.runClasses(preconditions_MRGC_32.class);
	     for (Failure failure : result.getFailures()) 
	         System.err.println(failure.toString());
	   
	      System.out.println();
	     System.out.println(result.wasSuccessful());
	     
	     Result result_TF_MRGC_32 = JUnitCore.runClasses(TF_MRGC_32.class);
	     for (Failure failure : result.getFailures()) 
	         System.err.println(failure.toString());
	   
	      System.out.println();
	     System.out.println(result.wasSuccessful());
	     
	     
	     
	}

}
