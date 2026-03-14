// Copyright 2025 Alex Chandarana

#include "shortanswerquestion.h"
#include <iostream>
using std::cout;
using std::endl;

namespace csce240_program6 {
ShortAnswerQuestion::ShortAnswerQuestion(string question, string answer)
    : Question(question), answer_(answer) {}

void ShortAnswerQuestion::Print(bool include_correct_answer) const {
  cout << "Question: " << GetQuestion() << endl;

  if (include_correct_answer) {
    cout << "Correct Answer: " << answer_ << endl;
  }
}
}  // namespace csce240_program6
