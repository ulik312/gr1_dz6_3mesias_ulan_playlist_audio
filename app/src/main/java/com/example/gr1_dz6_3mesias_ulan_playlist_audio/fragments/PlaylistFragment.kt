package com.example.gr1_dz6_3mesias_ulan_playlist_audio.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import com.example.gr1_dz6_3mesias_ulan_playlist_audio.R
import com.example.gr1_dz6_3mesias_ulan_playlist_audio.databinding.FragmentPlaylistBinding
import com.example.gr1_dz6_3mesias_ulan_playlist_audio.adapters.SongsAdapter
import com.example.gr1_dz6_3mesias_ulan_playlist_audio.models.Music

class PlaylistFragment : Fragment() {
    private lateinit var binding: FragmentPlaylistBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = SongsAdapter(uploadSongs(), this::onItemClick)
        binding.rvSongs.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

    private fun uploadSongs() = listOf(
        Music("1", "Ulukmanapo", "волчий вой", "3:00"),
        Music("1", "Ulukmanapo", "город", "3:00"),
        Music("1", "Ulukmanapo", "летали", "3:00"),
        Music("1", "Ulukmanapo", "амулет", "3:00"),
        Music("1", "Ulukmanapo", "так и понимай", "3:00"),
    )

    private fun onItemClick(title: String) {
        requireActivity().supportFragmentManager.findFragmentById(R.id.album_fragment)?.view?.isGone =
            true
        val bundle = Bundle()
        bundle.putString("приятного прослушивания", title)
        val singleSongFragment = SingleSongFragment()
        singleSongFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.songs_fragment, singleSongFragment).commit()
    }
}