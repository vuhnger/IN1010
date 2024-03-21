// Observable interface representing the social media feed
interface Feed {
    void postUpdate(String update);
    void addFollower(Follower follower);
    void notifyFollowers();
}
