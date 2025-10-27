package com.pierfrancescosoffritti.androidyoutubeplayer.core.player

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener

/**
 * Use this interface to control the playback of YouTube videos and to listen to their events.
 */
interface YouTubePlayer {
  /**
   * Loads and automatically plays the video.
   * @param videoId id of the video
   * @param startSeconds the time from which the video should start playing
   */
  fun loadVideo(videoId: String, startSeconds: Float)

  /**
   * Loads the video's thumbnail and prepares the player to play the video. Does not automatically play the video.
   * @param videoId id of the video
   * @param startSeconds the time from which the video should start playing
   */
  fun cueVideo(videoId: String, startSeconds: Float)

  /**
   * Loads and plays a playlist.
   * @param list The required list property contains a key that identifies the particular list of videos that YouTube should return.
   * @param listType If the listType property value is "playlist", then the list property specifies the playlist ID.
   *        In the YouTube Data API, the playlist resource's id property identifies a playlist's ID.
   * @param index Start index. The optional index property specifies the index of the first video in the list that will play.
   *        The parameter uses a zero-based index, and the default parameter value is 0.
   * @param startSeconds The optional startSeconds property accepts a float and specifies the time from which the first video
   *        in the list should start playing.
   */
  fun loadPlaylist(list: String, listType: String, index: Int, startSeconds: Float)

  fun play()
  fun pause()

  /** If the player is playing a playlist, play the next video. */
  fun nextVideo()
  /** If the player is playing a playlist, play the previous video. */
  fun previousVideo()
  /** If the player is playing a playlist, play the video at position [index]. */
  fun playVideoAt(index: Int)

  /** If the player is playing a playlist, enable or disable looping of the playlist. */
  fun setLoop(loop: Boolean)

  /** If the player is playing a playlist, enable or disable shuffling of the playlist. */
  fun setShuffle(shuffle: Boolean)

  fun mute()
  fun unMute()

  /** Returns true if the player is muted, false otherwise. */
  fun isMutedAsync(callback: BooleanProvider)

  /**
   * @param volumePercent Integer between 0 and 100
   */
  fun setVolume(volumePercent: Int)

  /**
   *
   * @param time The absolute time in seconds to seek to
   */
  fun seekTo(time: Float)

  fun setPlaybackRate(playbackRate: PlayerConstants.PlaybackRate)

  fun addListener(listener: YouTubePlayerListener): Boolean
  fun removeListener(listener: YouTubePlayerListener): Boolean
}
