// Copyright 2025 Alex Chandarana

#include "SongRecording.h"

namespace csce240_programming_assignment_5 {
  SongRecording::SongRecording(const string& title,
                               const string &primary_artist,
                               const int length, int number_of_artists) {
    if (title.length() > 0) {
      this->song_title_ = title;
    }
    if (number_of_artists < 1) {
      number_of_artists = 1;
    }
    artists_ = new string[number_of_artists];
    if (primary_artist.length() > 0) {
      artists_[0] = primary_artist;
    } else {
      artists_[0] = "unknown";
    }
    num_artists_ = number_of_artists;
    if (length >= 0) {
      length_ = length;
    }
  }

  SongRecording::SongRecording(const SongRecording& some) {
    song_title_ = some.song_title_;
    length_ = some.length_;
    num_artists_ = some.num_artists_;

    if (num_artists_ > 0 && some.artists_ != nullptr) {
      artists_ = new string[num_artists_];
      for (int i = 0; i < num_artists_; i++) {
        artists_[i] = some.artists_[i];
      }
    } else {
      artists_ = nullptr;
    }
  }

  SongRecording::~SongRecording() {
    delete[] artists_;
    artists_ = nullptr;
    num_artists_ = 0;
  }

  SongRecording& SongRecording::operator=(const SongRecording& other) {
    if (this != &other) {
      if (artists_ != nullptr) {
        delete[] artists_;
        artists_ = nullptr;
      }
      song_title_ = other.song_title_;
      length_ = other.length_;
      num_artists_ = other.num_artists_;
      if (num_artists_ > 0) {
        artists_ = new string[num_artists_];
        for (int i = 0; i < num_artists_; i++) {
          artists_[i] = other.artists_[i];
        }
      }
    }
    return *this;
  }

  string SongRecording::GetTitle() const { return SongRecording::song_title_; }

  void SongRecording::SetTitle(const string& title) {
    if (title.length() > 0) {
      song_title_ = title;
    }
  }

  int SongRecording::GetNumArtists() const {
    return num_artists_;
  }

  void SongRecording::SetNumArtists(const int num_artists) {
    if (num_artists > 0) {
      int count;
      if (num_artists < num_artists_) {
        count = num_artists;
      } else {
        count = num_artists_;
      }
      num_artists_ = num_artists;
      string* temp = artists_;
      artists_ = new string[num_artists];
      for (int i = 0; i < count; i++) {
        artists_[i] = temp[i];
      }
      delete[] temp;
    }
  }

  void SongRecording::SetArtist(const string& name, const int index) {
    if (index > 0 && index <= num_artists_ && name.length() > 0) {
      artists_[index-1] = name;
    }
  }

  string SongRecording::GetArtist(const int index) const {
    if (index <= num_artists_ && index > 0 && artists_ != nullptr) {
      return artists_[index-1];
    }
    return "out of bounds";
  }

  int SongRecording::GetTrackLength() const { return length_; }

  void SongRecording::SetTrackLength(const int length) {
    if (length >= 0) {
      length_ = length;
    }
  }
}  // namespace csce240_programming_assignment_5
