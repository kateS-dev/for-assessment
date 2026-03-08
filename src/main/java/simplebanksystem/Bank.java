package simplebanksystem;

class Bank {
    private long[] bank;

    public Bank(long[] balance) {
        bank = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (bank.length >= account1 && bank.length >= account2 && bank[account1-1] >= money) {
            bank[account1-1] -= money;
            bank[account2-1] += money;

            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (bank.length >= account && bank[account-1] >= money) {
            bank[account-1] -= money;

            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (bank.length >= account) {
            bank[account-1] += money;
            return true;
        }
        return false;
    }
}


