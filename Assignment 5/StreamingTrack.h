// Copyright Alex Chandarana 2025
#ifndef STREAMINGTRACK_H_
#define STREAMINGTRACK_H_

#include <string>
using std::string;

#include "SongRecording.h"

namespace csce240_programming_assignment_5 {

class StreamingTrack : public SongRecording {
 private:
  int streams_ = 0;
  string* genres_ = nullptr;
  int num_genres_ = 0;

 public:
  StreamingTrack(const string &title = "untitled",
  const string &primary_artist = "unknown",
  int track_length = 0,
  int num_artists = 1,
  const string &primary_genre = "pop",
  int streams = 0);

  StreamingTrack(const SongRecording& base,
  const string &primary_genre = "pop",
  int streams = 0);

  StreamingTrack(const StreamingTrack&);
  ~StreamingTrack();
  StreamingTrack& operator=(const StreamingTrack& other);

  // Returns # of streams
  int GetStreams() const;

  // Sets number of streams (non-negative)
  void SetStreams(int streams);

  // Increases number of streams by amount (non-negative)
  void AddStreams(int streams);

  // Returns # of genres
  int GetNumGenres() const;

  // Returns name of genre by index (1-based; "out of bounds" if invalid)
  string GetGenre(int index = 1) const;

  // Returns true if genre is one of the track's genres
  bool IsGenre(const string& genre) const;

  // Adds genre if not already present
  void AddGenre(const string& genre);

  // Removes genre if present
  void RemoveGenre(const string& genre);
};

}  // namespace csce240_programming_assignment_5

#endif  // STREAMINGTRACK_H_
