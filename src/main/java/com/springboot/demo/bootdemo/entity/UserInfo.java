
package com.springboot.demo.bootdemo.entity;

/**
 * Created by wangcm on 2018/1/13.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    //用户id;
    private long uid;
    @Column(unique = true)
    //账号.
    private String username;
    //名称（昵称或者真实姓名，不同系统不同定义）
    private String name;
    //密码;
    private String password;
    //加密密码的盐
    private String salt;
    //用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）
    // --等待验证的用户 , 1:正常状态,2：用户被锁定 .
    private byte state;
    //立即从数据库中进行加载数据;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns
            = {@JoinColumn(name = "roleId")})
    // 一个用户具有多个角色
    private List<SysRole> roleList;

    /**
     * 密码盐.
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }

    @Override
    public String toString() {
        return "UserInfo [uid=" + uid + ", username=" + username + ", name=" + name + ", password=" +
                password
                + ", salt=" + salt + ", state=" + state + "]";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
