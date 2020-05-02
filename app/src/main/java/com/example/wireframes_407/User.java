package com.example.wireframes_407;

public class User {

        private int id;
        private String username;
        private String sex;

        public User(String username, String sex) {
            this.username = username;
            this.sex = sex;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }

        public String getSex() {
            return sex;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }
//        @Override
//        public String toString() {
//            return "User [id=" + id + ", username=" + username + ", password="
//                    + password + ", age=" +  ", sex=" + sex + "]";
}



