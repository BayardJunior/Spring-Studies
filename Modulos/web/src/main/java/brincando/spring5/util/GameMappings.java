package brincando.spring5.util;

public final class GameMappings {

    public static final String PLAY = "play";

    public static final String RESTART = "restart";

    public static final String HOME = "/";

    public static final String REDIRECT_PLAY = "redirect:/".concat(PLAY);

    public GameMappings() {
    }
}
