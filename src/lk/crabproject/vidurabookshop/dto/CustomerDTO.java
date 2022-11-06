/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.dto;

/**
 *
 * @author DELL
 */
public class CustomerDTO {
   private String cid;
    private String name;
    private String address;
    private String JoinedDate;

    public CustomerDTO() {
    }

    public CustomerDTO(String cid, String name, String address, String JoinedDate) {
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.JoinedDate = JoinedDate;
    }

    public CustomerDTO(String cid) {
        this.cid=cid;
    }

    public String getJoinedDate() {
        return JoinedDate;
    }

    public void setJoinedDate(String JoinedDate) {
        this.JoinedDate = JoinedDate;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
     
}
