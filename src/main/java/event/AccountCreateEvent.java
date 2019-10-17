package event;

import domain.Account;
import state.AccountAggregate;

public class AccountCreateEvent extends DomainEvent {

    private final int accountNo;
    private final String owner;

    /**
     * Instantiates a new Account create event.
     *
     * @param sequenceId the sequence id
     * @param createdTime the created time
     * @param accountNo the account no
     * @param owner the owner
     */
    public AccountCreateEvent(long sequenceId, long createdTime, int accountNo, String owner) {
        super(sequenceId, createdTime, "AccountCreateEvent");
        this.accountNo = accountNo;
        this.owner = owner;
    }

    /**
     * Gets account no.
     *
     * @return the account no
     */
    public int getAccountNo() {
        return accountNo;
    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    @Override
    public void process() {
        Account account = AccountAggregate.getAccount(accountNo);
        if (account != null) {
            throw new RuntimeException("Account already exists");
        }
        account = new Account(accountNo, owner);
        account.handleEvent(this);
    }
}
