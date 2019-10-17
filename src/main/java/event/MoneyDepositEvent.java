package event;

import domain.Account;
import state.AccountAggregate;

import java.math.BigDecimal;

public class MoneyDepositEvent extends DomainEvent {

    private final BigDecimal money;
    private final int accountNo;

    /**
     * Instantiates a new Money deposit event.
     *
     * @param sequenceId the sequence id
     * @param createdTime the created time
     * @param accountNo the account no
     * @param money the money
     */
    public MoneyDepositEvent(long sequenceId, long createdTime, int accountNo, BigDecimal money) {
        super(sequenceId, createdTime, "MoneyDepositEvent");
        this.money = money;
        this.accountNo = accountNo;
    }

    /**
     * Gets money.
     *
     * @return the money
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * Gets account no.
     *
     * @return the account no
     */
    public int getAccountNo() {
        return accountNo;
    }

    @Override
    public void process() {
        Account account = AccountAggregate.getAccount(accountNo);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        account.handleEvent(this);
    }
}
