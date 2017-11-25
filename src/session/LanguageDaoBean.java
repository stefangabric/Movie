package session;
import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.Language;

@Stateless
@Local(LanguageDaoLocal.class)
public class LanguageDaoBean extends GenericDaoBean<Language, Integer> implements
LanguageDaoLocal {

}
