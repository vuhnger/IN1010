import java.util.ArrayList; 
import java.util.List;

// Concrete observable representing the social media feed
class SocialMediaFeed implements Feed {
    private List<Follower> followers = new ArrayList<>();
    private String update;


    @Override
    public void postUpdate(String update) {
        this.update = update;
        notifyFollowers();
    }


    @Override
    public void addFollower(Follower follower) {
        followers.add(follower);
    }


    @Override
    public void notifyFollowers() {
        for (Follower follower : followers) {
            follower.receiveUpdate(update);
        }
    }
}
