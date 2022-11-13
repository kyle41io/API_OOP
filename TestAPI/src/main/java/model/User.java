package model;

public class User {
    private String name;
    private String role;
    private String avatar;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String user_id;

    public User() {
    }

    public User(String name, String role, String avatar, String email, String password, String address, String phone) {
        this.name = name;
        this.role = role;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(User user) {
        if (user == null)
            return false;

        if (name != null){
            if (name.equals(user.getName()))
                return false;
        }
        else {
            if (user.getName() != null)
                return false;
        }

        if (role != null){
            if (role.equals(user.getRole()))
                return false;
        }
        else {
            if (user.getRole() != null)
                return false;
        }

        if (avatar != null){
            if (avatar.equals(user.getAvatar()))
                return false;
        }
        else {
            if (user.getAvatar() != null)
                return false;
        }

        if (email != null){
            if (email.equals(user.getEmail()))
                return false;
        }
        else {
            if (user.getEmail() != null)
                return false;
        }

        if (address != null){
            if (address.equals(user.getAddress()))
                return false;
        }
        else {
            if (user.getAddress() != null)
                return false;
        }

        if (phone != null){
            if (phone.equals(user.getPhone()))
                return false;
        }
        else {
            if (user.getPhone() != null)
                return false;
        }

        return true;
    }
}
