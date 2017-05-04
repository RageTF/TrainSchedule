package spring.model.pojo;

import javax.persistence.*;

/**
 * Created by Rage on 03.05.2017.
 */
@Entity
@Table(name = "table_users", schema = "trainschedule")
public class UsersEntity {
    private int mUserId;
    private String mUserPassword;
    private String mUserLogin;

    @Id
    @Column(name = "user_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return mUserPassword;
    }

    public void setUserPassword(String userPassword) {
        mUserPassword = userPassword;
    }

    @Basic
    @Column(name = "user_login")
    public String getUserLogin() {
        return mUserLogin;
    }

    public void setUserLogin(String userLogin) {
        mUserLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (mUserId != that.mUserId) return false;
        if (mUserPassword != null ? !mUserPassword.equals(that.mUserPassword) : that.mUserPassword != null)
            return false;
        if (mUserLogin != null ? !mUserLogin.equals(that.mUserLogin) : that.mUserLogin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mUserId;
        result = 31 * result + (mUserPassword != null ? mUserPassword.hashCode() : 0);
        result = 31 * result + (mUserLogin != null ? mUserLogin.hashCode() : 0);
        return result;
    }
}
