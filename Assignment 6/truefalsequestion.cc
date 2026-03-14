// Copyright 2025 Alex Chandarana

#include "truefalsequestion.h"
#include <iostream>
using std::cout;
using std::endl;

namespace csce240_program6 {

TrueFalseQuestion::TrueFalseQuestion(string question, bool answer)
    : Question(question), answer_(answer) {}

void TrueFalseQuestion::Print(bool include_correct_answer) const {
  cout << "Question: " << GetQuestion() << endl;

  if (include_correct_answer) {
    cout << "Correct Answer: " << (answer_ ? "true" : "false") << endl;
  }
}

}  // namespace csce240_program6
