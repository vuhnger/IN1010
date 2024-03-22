// Concrete SocialMediaFollower representing a Follower
class SocialMediaFollower implements Follower {
    private String name;
    public SocialMediaFollower(String name) {
        this.name = name;
    }


    @Override
    public void receiveUpdate(String update) {
        System.out.println(name + " received update: " + update);
    }
}
