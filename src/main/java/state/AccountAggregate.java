package state;

import domain.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountAggregate {

    private static Map<Integer, Account> accounts = new HashMap<Integer, Account>();

    private AccountAggregate() {
    }

    /**
     * Put account.
     *
     * @param account the account
     */
    public static void putAccount(Account account) {
        accounts.put(account.getAccountNo(), account);
    }

    /**
     * Gets account.
     *
     * @param accountNo the account no
     * @return the copy of the account or null if not found
     */
    public static Account getAccount(int accountNo) {
        Account account = accounts.get(accountNo);
        if (account == null) {
            return null;
        }
        return account.copy();
    }

    /**
     * Reset state.
     */
    public static void resetState() {
        accounts = new HashMap<Integer, Account>();
    }
}