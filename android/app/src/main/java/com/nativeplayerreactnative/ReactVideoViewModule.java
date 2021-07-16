package com.nativeplayerreactnative;

import android.app.PictureInPictureParams;
import android.view.View;
import android.widget.Toast;

import com.nativeplayerreactnative.R;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class ReactVideoViewModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext mReactContext;

    public static ReactVideoView mVideoView;

    public ReactVideoViewModule(ReactApplicationContext reactContext) {
        super(reactContext);

        mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RCTVideoView";
    }

    /* @ReactMethod
    public void play(int tag) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            ((PlayerView) playerView).getPlayer().play();
        } else {
            throw new ClassCastException(
                    String.format("Cannot play: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void pause(int tag) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            ((PlayerView) playerView).getPlayer().pause();
        } else {
            throw new ClassCastException(
                    String.format("Cannot pause: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void seek(int tag, double time) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            ((PlayerView) playerView).getPlayer().seek(time);
        } else {
            throw new ClassCastException(
                    String.format("Cannot seek: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void mute(int tag) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            ((PlayerView) playerView).getPlayer().mute();
        } else {
            throw new ClassCastException(
                    String.format("Cannot mute: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void unmute(int tag) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            ((PlayerView) playerView).getPlayer().unmute();
        } else {
            throw new ClassCastException(
                    String.format("Cannot unmute: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }
 */
    /* @ReactMethod
    public void enterFullscreen(int tag) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {

            ((PlayerView) playerView).enterFullscreen();
        } else {
            throw new ClassCastException(
                    String.format("Cannot enterFullscreen: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void exitFullscreen(int tag) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            ((PlayerView) playerView).exitFullscreen();
        } else {
            throw new ClassCastException(
                    String.format("Cannot exitFullscreen: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }
 */
    @ReactMethod
    public void enterPictureInPicture() {

        try {
            getCurrentActivity().enterPictureInPictureMode();
            mVideoView.setInPiP();
        } catch (Exception exception) {
            Toast.makeText(mReactContext, "oh shit", Toast.LENGTH_LONG).show();
        }
    }

    public static void setVideoView(ReactVideoView videoView){
        mVideoView = videoView;
    }

    @ReactMethod
    public void play() {
        mVideoView.play();
    }

    @ReactMethod
    public void pause() {
        mVideoView.pause();
    }

    @ReactMethod
    public void restart(){
        mVideoView.reset();
    }

    @ReactMethod
    public void stop(){
        mVideoView.stop();
    }

    @ReactMethod
    public void isInPiP(Callback cbk){
         cbk.invoke(mVideoView.getInPiP());
    }

/*     @ReactMethod
    public void getCurrentTime(int tag, Promise promise) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            double currentTime = ((PlayerView) playerView).getPlayer().getCurrentTime();

            promise.resolve(currentTime);
        } else {
            throw new ClassCastException(
                    String.format("Cannot getCurrentTime: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void getDuration(int tag, Promise promise) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            double duration = ((PlayerView) playerView).getPlayer().getDuration();

            promise.resolve(duration);
        } else {
            throw new ClassCastException(
                    String.format("Cannot getDuration: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void getVolume(int tag, Promise promise) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            int volume = ((PlayerView) playerView).getPlayer().getVolume();

            promise.resolve(volume);
        } else {
            throw new ClassCastException(
                    String.format("Cannot getVolume: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void setVolume(int tag, int volume) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            ((PlayerView) playerView).getPlayer().setVolume(volume);
        } else {
            throw new ClassCastException(
                    String.format("Cannot setVolume: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void isMuted(int tag, Promise promise) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            boolean isMuted = ((PlayerView) playerView).getPlayer().isMuted();

            promise.resolve(isMuted);
        } else {
            throw new ClassCastException(
                    String.format("Cannot isMuted: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void isPaused(int tag, Promise promise) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            boolean isPaused = ((PlayerView) playerView).getPlayer().isPaused();

            promise.resolve(isPaused);
        } else {
            throw new ClassCastException(
                    String.format("Cannot isPaused: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void isStalled(int tag, Promise promise) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            boolean isStalled = ((PlayerView) playerView).getPlayer().isStalled();

            promise.resolve(isStalled);
        } else {
            throw new ClassCastException(
                    String.format("Cannot isStalled: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    }

    @ReactMethod
    public void isPlaying(int tag, Promise promise) {
        View playerView = getCurrentActivity().findViewById(tag);

        if (playerView instanceof PlayerView) {
            boolean isPlaying = ((PlayerView) playerView).getPlayer().isPlaying();

            promise.resolve(isPlaying);
        } else {
            throw new ClassCastException(
                    String.format("Cannot isPlaying: view with tag #%d is not a RNBitmovinPlayer", tag));
        }
    } */
}
