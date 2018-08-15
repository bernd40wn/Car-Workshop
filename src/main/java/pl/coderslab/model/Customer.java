package pl.coderslab.model;

public class Customer {
    import java.util.Date;

    public class Customer {
        private String name;
        private String surename;
        private Date birthday;
        private int id=0;
        private in phonenumber;
        private String adress''


        public Customer() {
        }

        public Customer(String name, String surename, Date birthday, in phonenumber, String adress) {
            this.name = name;
            this.surename = surename;
            this.birthday = birthday;
            this.phonenumber = phonenumber;
            this.adress = adress;
        }

        public in getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(in phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurename() {
            return surename;
        }

        public void setSurename(String surename) {
            this.surename = surename;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

}
