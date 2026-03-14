// Copyright 2025 Alex Chandarana
#ifndef _TRUEFALSEQUESTION_H_
#define _TRUEFALSEQUESTION_H_

#include <string>
#include "question.h"
using std::string;

namespace csce240_program6 {

class TrueFalseQuestion : public Question {
 public:
  // Constructor
  explicit TrueFalseQuestion(string question = "?", bool answer = true);

  // Accessor
  bool GetAnswer() const { return answer_; }

  // Mutator
  void SetAnswer(bool answer) { answer_ = answer; }

  // Print
  void Print(bool include_correct_answer = false) const override;

  // Destructor
  virtual ~TrueFalseQuestion() {}

 private:
  bool answer_;
};
}  // namespace csce240_program6

#endif  // _TRUEFALSEQUESTION_H_
