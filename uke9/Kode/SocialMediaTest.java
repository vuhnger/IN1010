public class SocialMediaTest {
    public static void main(String[] args) {
        Feed feed = new SocialMediaFeed();
        for (int x = 0; x < 5; x++){
            feed.addFollower(new SocialMediaFollower("Follower #"+x+1));
        }

        feed.postUpdate("Værmeldingen i dag: 20c og sol! ");
    }
}
