package application.services;

import application.dao.CustomerDaoException;

public interface AccountService {

    public void openAccount(int customerId, int initialValue) throws CustomerDaoException;
}
