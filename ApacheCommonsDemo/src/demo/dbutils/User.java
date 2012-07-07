package demo.dbutils;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class User implements Serializable {

    private static final long serialVersionUID = 913478757260526919L;

    private String aname;
    private String password;
    private int sex;
    private String province;
    private String city;
    private Date create_time;
    private Date last_login_time;
    private String title;
    private int theme_id;
    private int count;
    private boolean status;

    public User() {
        super();
    }

    public String toString() {
        return new ToStringBuilder(this).append("aname", aname).append("password", password).append("create_time", create_time).append(
                "last_login_time", last_login_time).append("title", title).append("template", theme_id).append("count", count).append("status",
                status).toString();
    }

    public boolean equals(Object o) {
        if (!(o instanceof User))
            return false;

        if (this == o)
            return true;

        User casto = (User) o;
        return new EqualsBuilder().append(aname, casto.getAname()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(aname).toHashCode();
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
        this.theme_id = theme_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
