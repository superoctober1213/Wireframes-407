package com.example.wireframes_407;

public class User {

        private String username;
        private String gender;
        private String email;

        public User(String email, String username, String gender) {
            this.username = username;
            this.gender = gender;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }

        public String getSex() {
            return gender;
        }
        public void setSex(String sex) {
            this.gender = gender;
        }
//        @Override
//        public String toString() {
//            return "User [id=" + id + ", username=" + username + ", password="
//                    + password + ", age=" +  ", sex=" + sex + "]";
}



