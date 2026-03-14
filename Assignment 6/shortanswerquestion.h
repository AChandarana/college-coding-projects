// Copyright 2025 Alex Chandarana

#ifndef _SHORTANSWERQUESTION_H_
#define _SHORTANSWERQUESTION_H_

#include <string>
#include "question.h"
using std::string;

namespace csce240_program6 {

class ShortAnswerQuestion : public Question {
 public:
  // Constructor
  explicit ShortAnswerQuestion(string question = "?", string answer = "");

  // Accessor
  string GetAnswer() const { return answer_; }

  // Mutator
  void SetAnswer(const string& answer) { answer_ = answer; }

  // Print
  void Print(bool include_correct_answer = false) const override;

  // Destructor
  virtual ~ShortAnswerQuestion() {}

 private:
  string answer_;
};

}  // namespace csce240_program6

#endif  // _SHORTANSWERQUESTION_H_
