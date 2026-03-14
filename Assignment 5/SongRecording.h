// Copyright Alex Chandarana 2025
#ifndef SONGRECORDING_H_
#define SONGRECORDING_H_

#include <string>
using std::string;

namespace csce240_programming_assignment_5 {

class SongRecording {
 private:
  string song_title_ = "untitled";
  string* artists_ = nullptr;
  int num_artists_ = 1;
  int length_ = 0;

 public:
  SongRecording(const string& title = "untitled",
  const string &primary_artist = "unknown",
  int length = 0, int number_of_artists = 1);
  SongRecording(const SongRecording&);
  ~SongRecording();
  SongRecording& operator=(const SongRecording&);

  // Returns the title
  string GetTitle() const;

  // Sets the title to a valid string
  void SetTitle(const string& title);

  // Returns the number of artists
  int GetNumArtists() const;

  // Sets the number of artists to a valid int
  void SetNumArtists(int num_artists);

  // Sets the primary artists to a valid string
  void SetArtist(const string& name, int index = 1);

  // Returns the artist at an index
  string GetArtist(int index = 1) const;

  // Returns the length in seconds
  int GetTrackLength() const;

  // Sets the lenth to a valid int in seconds
  void SetTrackLength(int length);
};

}  // namespace csce240_programming_assignment_5

#endif  // SONGRECORDING_H_
