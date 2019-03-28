package com.example.rt.pl;

public class DB {
    private String fname;
    private String lname;
    private String username;
    private String p_no;
    private String ea;
    private String pass;
    private String uid;

    public DB() {
    }

    public DB(String id, String fname, String lname, String username, String p_no, String email, String pass) {
        this.uid = id;
        this.fname = fname;
        this.ea = email;
        this.lname = lname;
        this.username = username;
        this.p_no = p_no;
        this.pass = pass;
    }


    public String getFName() {
        return fname;
    }

    public String getLName() {
        return lname;
    }

    public String getEmail() {
        return ea;
    }

    public String getUsername(){
        return username;
    }

    public String getId(){
        return uid;
    }

    public String getPhone(){
        return p_no;
    }

    public String getPass(){
        return pass;
    }



    public void setFname(String name) {
        this.fname = name;
    }

    public void setLName(String name) {
        this.lname = name;
    }

    public void setEmail(String email) {
        this.ea = email;
    }


    public void setPass(String password) {
        this.pass = password;
    }


    public void setId(String id) {
        this.uid = id;
    }


    public void setPhone(String phone) {
        this.p_no = phone;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

}
