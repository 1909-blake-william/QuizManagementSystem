/**
 * author: Kamilah Carlisle
 * date due: Jane 6, 2020
 * description: this junit test will make sure the servlet filter is behaving as expected
 * the boolean values will be determined by the uri provided to each test method
*/
//Very important for when statements
import static org.mockito.Mockito.*;

//SQL imports
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;*/

//Servlet imports
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import com.revature.daos.UserDao;

//Allows you to run Mockito test as a Junit test
/*import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;*/

//Annotations
//allows you to use test annotation
import org.junit.Test;
//allows you to use mock annotation
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//allows you to use before annotation
import org.junit.Before;
//allows you to use rule annotation
/*import org.junit.Rule;

//Daos and Models
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;


import org.junit.Test;*/

public class ServletFilterTest {
	 @Mock
	    HttpServletRequest request;
	 
	    @Mock
	    HttpServletResponse response;
	    
	    @Mock
	    String loginUri, currentQuizUri, pastQuizUri, newQuizUri;
	    @Before
	    public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	    }
	@Test
	public void testPostEndPoints() {
		//fail("Not yet implemented");
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		
		
	}
	
	@Test
	public void testGetEndPoints() {
		
	}

	@Test
	public void testPutEndPoints() {
		 
	}
}
