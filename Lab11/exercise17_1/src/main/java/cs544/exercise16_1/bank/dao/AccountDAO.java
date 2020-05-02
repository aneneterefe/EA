package cs544.exercise16_1.bank.dao;

import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.exercise16_1.bank.domain.Account;
@Transactional(propagation = Propagation.MANDATORY)
public class AccountDAO implements IAccountDAO {
	
	private SessionFactory sf;
	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sf) {
		this.sf=sf;
	}
	
	public void saveAccount(Account account) {
		sf.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		sf.getCurrentSession().saveOrUpdate(account);
	}

	public Account loadAccount(long accountnumber) {
		return (Account)sf.getCurrentSession().get(Account.class, accountnumber);
	}

	@SuppressWarnings("unchecked")
	public Collection<Account> getAccounts() {
		return sf.getCurrentSession().createQuery("from Account").list();
	}

}
