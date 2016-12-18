package models;

import controllers.backend.AccountBE;

/**
 * Created by MUSIQUE on 29/11/2015.
 */

public class UserAccount {

    public static final int ROOT_USER = 0;
    public static final int ADMIN_USER = 2;
    public static final int SUPER_USER = 5;
    public static final int USER = 10;

    private int id;
    private int clientAccountId;
    private int societyId;
    private int profile;

    private String username;
    private String password;

    public UserAccount() {this.id = 0; }
    public UserAccount(int id) {
        this.id = id;
    }

    public void setUsername ( String login ) {
        this.username = login;
    }
    public void setPassword ( String password ) {
        this.password = password;
    }
    public String getUsername() { return this.username; }
    public String getPassword () {
        return this.password;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    /*public static UserAccount getUser(int id) {
        UserAccount user_account = new UserAccount(id);
        user_account.setId(id);
        user_account.setUsername("");
        user_account.setPassword("");
        user_account.setProfile(UserAccount.USER);
        return user_account;
    }*/

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getClientAccountId() { return this.clientAccountId; }
    public void setClientAccountId( int ClientAccountId ) {this.clientAccountId = ClientAccountId; }

    public Account getClientAccount() {
        Account clientAccount = AccountBE.getAccount(this.clientAccountId);
        return clientAccount;
    }

    public void setClientAccount(Account clientAccount) {
        this.clientAccountId = clientAccount.getId();
    }

    public int getSocietyId() {
        return societyId;
    }

    public void setSocietyId(int societyId) {
        this.societyId = societyId;
    }

    public String getProfileStr () {
        String userType = "";
        switch (this.profile) {
            case UserAccount.USER:
                userType = "user";
                break;
            case UserAccount.SUPER_USER:
                userType = "super_user";
                break;
            case UserAccount.ROOT_USER:
                userType = "root_user";
                break;
            case UserAccount.ADMIN_USER:
                userType = "admin_user";
                break;
        }

        return userType;
    }
}
