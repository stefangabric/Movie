package session;
import entity.User;

public interface UserDaoLocal extends GenericDaoLocal<User, Integer> {

	User findUserSaKorisnickimImenomILozinkom(String korisnickoIme, String lozinka);
	public User Login(String username, String password);

}
