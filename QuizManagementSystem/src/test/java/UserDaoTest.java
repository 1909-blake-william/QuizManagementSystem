//Very important for when statements
import static org.mockito.Mockito.*;

//SQL imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import com.revature.daos.UserDao;

//Allows you to run Mockito test as a Junit test
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

//Annotations
//allows you to use test annotation
import org.junit.Test;
//allows you to use mock annotation
import org.mockito.Mock;
//allows you to use before annotation
import org.junit.Before;
//allows you to use rule annotation
import org.junit.Rule;

//Daos and Models
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;




public class UserDaoTest {
	
	@Mock
	private Connection database;
	UserDaoImpl test = mock(UserDaoImpl.class);
	@Mock
	private PreparedStatement ps;
	@Mock
	ResultSet rs;
	@Mock
	private User currentUser;
	//private UserDaoImpl instance;
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws Exception{
		/*when(database.prepareStatement(any(String.class))).thenReturn(ps);
		/*public User(int userId, int typeId, String username, String password, 
			String firstname, String lastname, String email, int groupId, int resultsId) {*/
		
		currentUser = new User(1, 2, "user1","pass","first", "last", "email@gmail.com", 1, 0);
		/*INSERT INTO QUIZ_USER(user_id, type_id, user_name, user_pass, firstname, lastname, email, group_id, results_id)
VALUES (user_id_seq.nextval, 2, 'mCampbell', 'pass', 'Madeline', 'Campbell', 'mCampbell@gmail.com', 1, null);
		//when.thenReturn is used to specify a return value for a method call 
		//with pre-defined parameters.
		when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(currentUser.getUserId());
        when(rs.getInt(2)).thenReturn(currentUser.getTypeId());
        
        when(rs.getString(3)).thenReturn(currentUser.getUsername());
        when(rs.getString(4)).thenReturn(currentUser.getPassword());
        when(rs.getString(5)).thenReturn(currentUser.getFirstname());
        when(rs.getString(6)).thenReturn(currentUser.getLastname());
        when(rs.getString(7)).thenReturn(currentUser.getEmail());
        when(rs.getInt(8)).thenReturn(currentUser.getGroupId());
        when(rs.getInt(9)).thenReturn(currentUser.getResultsId());
        when(ps.executeQuery()).thenReturn(rs);*/
	}
	
	@Test
	public void testConnection() {
		
	}
	 @Test
	    public void testSaveUser() {
	        test.saveUser(currentUser);
	        /*boolean createdUser = 
	        assertTrue();*/
	    }
	 
	 @Test
	 public void testFindByUsernameAndPassword() {
		 test.findByUsernameAndPassword(currentUser.getUsername(), currentUser.getPassword());
	 }
	
}
