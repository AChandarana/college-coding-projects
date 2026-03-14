// Copyright 2025 Alex Chandarana

#include "StreamingTrack.h"

namespace csce240_programming_assignment_5 {
  StreamingTrack::StreamingTrack(const string &title,
                                 const string &primary_artist,
                                 const int track_length,
                                 const int num_artists,
                                 const string &primary_genre,
                                 const int streams)
      : SongRecording(title, primary_artist, track_length, num_artists) {
    streams_ = (streams >= 0) ? streams : 0;
    num_genres_ = 1;
    genres_ = new string[num_genres_];
    genres_[0] = primary_genre;
  }

  StreamingTrack::StreamingTrack(const StreamingTrack& other)
      : SongRecording(other) {
    streams_ = other.streams_;
    num_genres_ = other.num_genres_;
    if (num_genres_ > 0 && other.genres_ != nullptr) {
      genres_ = new string[num_genres_];
      for (int i = 0; i < num_genres_; i++) {
        genres_[i] = other.genres_[i];
      }
    } else {
      genres_ = nullptr;
    }
  }

  StreamingTrack::StreamingTrack(const SongRecording& base,
                               const string& primary_genre,
                               const int streams)
    : SongRecording(base) {
    if (streams >= 0) {
      streams_ = streams;
    }
    num_genres_ = 1;
    genres_ = new string[num_genres_];
    genres_[0] = primary_genre;
  }

  StreamingTrack& StreamingTrack::operator=(const StreamingTrack& other) {
    if (this != &other) {
      SongRecording::operator=(other);
      streams_ = other.streams_;
      if (genres_ != nullptr) {
        delete[] genres_;
        genres_ = nullptr;
      }
      num_genres_ = other.num_genres_;
      if (num_genres_ > 0 && other.genres_ != nullptr) {
        genres_ = new string[num_genres_];
        for (int i = 0; i < num_genres_; i++) {
          genres_[i] = other.genres_[i];
        }
      }
    }
    return *this;
  }

  StreamingTrack::~StreamingTrack() {
    delete[] genres_;
    genres_ = nullptr;
    num_genres_ = 0;
  }

  int StreamingTrack::GetStreams() const {
    return streams_;
  }

  void StreamingTrack::SetStreams(const int streams) {
    if (streams >= 0) {
      streams_ = streams;
    }
  }

  void StreamingTrack::AddStreams(const int streams) {
    if (streams >= 0) {
      streams_ += streams;
    }
  }

  int StreamingTrack::GetNumGenres() const {
    return num_genres_;
  }

  string StreamingTrack::GetGenre(int index) const {
    if (index > 0 && index <= num_genres_) {
      return genres_[index - 1];
    } else {
      return "out of bounds";
    }
  }

  bool StreamingTrack::IsGenre(const string &genre) const {
    for (int i = 0; i < num_genres_; i++) {
      if (genre == genres_[i]) {
        return true;
      }
    }
    return false;
  }

  void StreamingTrack::AddGenre(const string &genre) {
    for (int i = 0; i < num_genres_; i++) {
      if (genre == genres_[i]) {
        return;
      }
    }
    const string * temp = genres_;
    num_genres_++;
    genres_ = new string[num_genres_];
    for (int i = 0; i < num_genres_-1; i++) {
      genres_[i] = temp[i];
    }
    genres_[num_genres_-1] = genre;
    delete[] temp;
  }

  void StreamingTrack::RemoveGenre(const string &genre) {
    bool found = false;
    int index = 0;
    for (int i = 0; i < num_genres_; i++) {
      if (genre == genres_[i]) {
        found = true;
        index = i;
        break;
      }
    }
    if (!found) {
      return;
    }
    num_genres_--;
    const string * temp = genres_;
    genres_ = new string[num_genres_];
    for (int i = 0; i < index; i++) {
      genres_[i] = temp[i];
    }
    for (int i = index; i < num_genres_; i++) {
      genres_[i] = temp[i + 1];
    }
    delete[] temp;
  }
}  // namespace csce240_programming_assignment_5
