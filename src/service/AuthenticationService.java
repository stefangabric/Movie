package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.User;
import session.MovieDaoLocal;
import session.UserDaoLocal;

@Path("/auth")
public class AuthenticationService {
	@EJB
	private UserDaoLocal udl;
	
	@EJB
	private MovieDaoLocal movieDao;
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public User authenticateUser(
		@FormParam("username") String username, 
        @FormParam("password") String password) {
		User user=null;
		List<User>users=udl.findAll();
		for (User user2 : users) {
			if (user2.getUsername().equals(username)&& user2.getPass().equals(password)) {
				user=user2;
			}
		}
		return user;
	}		
	
}
