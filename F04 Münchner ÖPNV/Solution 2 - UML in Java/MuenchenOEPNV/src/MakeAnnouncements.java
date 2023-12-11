public interface MakeAnnouncements {
    default void announce(String message) {
        System.out.println("Attention passengers! " + message);
    }
}
