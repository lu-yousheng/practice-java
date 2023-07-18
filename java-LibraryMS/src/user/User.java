package user;

import opera.IOperation;

public abstract class User {
    protected String name;
    public IOperation[] operations;
    public User(String name) {
        this.name = name;
    }

    public abstract int menu();
}
