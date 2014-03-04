package com.dataart.clientvideostream.player;

/**
 * Created by vpopov on 3/4/14.
 */
public final class PlayerFactory {
    public static IPlayerController newPlayer() {
        return new DefaultPlayerController();
    }
}
