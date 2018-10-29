package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {


    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {

    verifyAccountDetails(account);
    setAccountDetails(account);
    createAccount(account);
    }
    public void verifyAccountDetails(Account account)
    {
        verifyAccountName(account);
        verifyAccountPassword(account);
    }

    public void setAccountDetails(Account account)
    {
        setAccountCreationDate(account);
        setAccountAddresses(account);
    }

    public void createAccount(Account account)
    {
        accountManager.createNewAccount(account);
    }


    public void verifyAccountName(Account account)
    {
        if (account.getName().length() <= 5){
            throw new WrongAccountNameException();
        }
    }
    public void verifyAccountPassword(Account account)
    {
        String password = account.getPassword();
        if (password.length() <= 8) {
            if (passwordChecker.validate(password) != OK) {
                throw new WrongPasswordException();
            }
        }

    }
    public void setAccountCreationDate(Account account)
    {
        account.setCreatedDate(new Date());
    }

    public void setAccountAddresses(Account account)
    {

        account.setAddresses(getAllTheAddressesOfAccountHolder(account));

    }

    public List<Address> getAllTheAddressesOfAccountHolder(Account account)
    {
        List<Address> addresses = new ArrayList<>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        return addresses;
    }





    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {

        this.passwordChecker = passwordChecker;
    }

}
