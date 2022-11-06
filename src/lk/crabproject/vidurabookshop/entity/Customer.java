package lk.crabproject.vidurabookshop.entity;
public class Customer {
    private String cid;
    private String name;
    private String address;
    private String JoinedDate;

    public Customer() {
    }

    public Customer(String cid, String name, String address, String JoinedDate) {
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.JoinedDate = JoinedDate;
    }

    public Customer(String cid) {
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
