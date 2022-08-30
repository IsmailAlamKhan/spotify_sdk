package de.minimalme.spotify_sdk

import com.spotify.android.appremote.api.SpotifyAppRemote
import io.flutter.plugin.common.MethodChannel

class SpotifyConnectApi(spotifyAppRemote: SpotifyAppRemote?, result: MethodChannel.Result) :
    BaseSpotifyApi(spotifyAppRemote, result) {
    private val connectApi = spotifyAppRemote?.connectApi
    private val errorConnectSwitchToLocalDevice = "connectSwitchToLocalDeviceError"
    internal fun connectSwitchToLocalDevice() {
        if (connectApi != null) {
            connectApi.connectSwitchToLocalDevice()
                .setResultCallback { result.success(true) }
                .setErrorCallback { throwable ->
                    result.error(
                        errorConnectSwitchToLocalDevice,
                        "error when switching to local device",
                        throwable.toString()
                    )
                }
        } else {
            spotifyRemoteAppNotSetError()
        }
    }
}