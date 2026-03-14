// Copyright 2025 Alex Chandarana

#ifndef _MULTIPLECHOICEQUESTION_H_
#define _MULTIPLECHOICEQUESTION_H_

#include <string>
#include "question.h"
using std::string;

namespace csce240_program6 {

class MultipleChoiceQuestion : public Question {
 public:
  explicit MultipleChoiceQuestion(string question = "?", int num_choices = 0,
                                  const string* choices = nullptr,
                                  const bool* correct = nullptr);

  // Copy constructor
  MultipleChoiceQuestion(const MultipleChoiceQuestion& other);

  // Assignment operator
  MultipleChoiceQuestion& operator=(const MultipleChoiceQuestion& other);

  // Destructor
  virtual ~MultipleChoiceQuestion();

  // Accessor
  int GetNumChoices() const { return num_choices_; }

  // Mutator
  void SetAnswerChoices(int num_choices, const string* choices,
                        const bool* correct);

  // Print
  void Print(bool include_correct_answer = false) const override;

 private:
  int num_choices_;
  string* choices_;
  bool* correct_choices_;
};

}  // namespace csce240_program6

#endif  // _MULTIPLECHOICEQUESTION_H_

