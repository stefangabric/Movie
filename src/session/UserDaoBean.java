package session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.User;

@Stateless
@Local(UserDaoLocal.class)
public class UserDaoBean extends GenericDaoBean<User, Integer> implements
UserDaoLocal {

	@Override
	public User findUserSaKorisnickimImenomILozinkom(String korisnickoIme, String lozinka) {
		{
			Query q = em
					.createNamedQuery("findUserSaKorisnickimImenomILozinkom");
			q.setParameter("user_name", korisnickoIme);
			q.setParameter("user_pass", lozinka);
			User result = (User) q.getSingleResult();
			return result;
			
		}
	}
	public User Login(String username, String password) {
		try {
            // Authenticate the user using the credentials provided
            User user = findUserSaKorisnickimImenomILozinkom(username, password);
            if(user!=null){
            	return user;
            }
            else
            	return null;
        } catch (Exception e) {
            return null;
        }
	}


	


}
