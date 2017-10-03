package repeatcode.fpt.canhhh.musicapp.model;

/**
 * Created by canhh on 20/07/2017.
 */

public class MusicModel {

    private String singer,song;

    public MusicModel() {
    }

    public MusicModel(String singer, String song) {
        this.singer = singer;
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
