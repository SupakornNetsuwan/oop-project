package model;

public class UserModel {
    private User user ;

   public UserModel(String username, String password, int level){
       user = new User(username, password, level);
   }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
