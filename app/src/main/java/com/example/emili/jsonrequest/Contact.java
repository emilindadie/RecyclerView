package com.example.emili.jsonrequest;

/**
 * Created by emili on 30/06/2017.
 */

public class Contact {

    String id;
    String name ;
    String email ;
    String address;
    String gender ;




    public Contact() {


    }
    public Contact(String id, String name, String email, String address, String gender) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){

        return  id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){

        return  name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){

        return  email;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){

        return  address;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){

        return  gender;
    }


}
