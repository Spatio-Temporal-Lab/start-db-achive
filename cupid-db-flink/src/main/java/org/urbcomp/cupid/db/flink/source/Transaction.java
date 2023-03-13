package org.urbcomp.cupid.db.flink.source;

import java.io.Serializable;
import java.util.Objects;

public class Transaction implements Serializable {
    public long accountId;      // 交易账户
    public long timestamp;      // 交易时间
    public double amount;       // 交易金额

    public Transaction() { }

    public Transaction(long accountId, long timestamp, double amount) {
        this.accountId = accountId;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return accountId == that.accountId &&
                timestamp == that.timestamp &&
                Double.compare(that.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, timestamp, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountId=" + accountId +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                '}';
    }
}