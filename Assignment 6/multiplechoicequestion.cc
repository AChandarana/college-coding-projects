// Copyright 2025 Alex Chandarana
#include "multiplechoicequestion.h"
#include <iostream>
using std::cout;
using std::endl;

namespace csce240_program6 {

MultipleChoiceQuestion::MultipleChoiceQuestion(
    string question, int num_choices,
    const string* choices, const bool* correct)
    : Question(question), num_choices_(num_choices) {

  if (num_choices_ == 0) {
    choices_ = nullptr;
    correct_choices_ = nullptr;
    return;
  }

  choices_ = new string[num_choices_];
  correct_choices_ = new bool[num_choices_];

  if (choices == nullptr && correct == nullptr) {
    for (int i = 0; i < num_choices_; ++i) {
      choices_[i] = "";
      correct_choices_[i] = true;
    }

  } else if (choices != nullptr && correct == nullptr) {
    for (int i = 0; i < num_choices_; ++i) {
      choices_[i] = choices[i];
      correct_choices_[i] = true;
    }

  } else if (choices != nullptr && correct != nullptr) {
    for (int i = 0; i < num_choices_; ++i) {
      choices_[i] = choices[i];
      correct_choices_[i] = correct[i];
    }

  } else {
    for (int i = 0; i < num_choices_; ++i) {
      choices_[i] = "";
      correct_choices_[i] = correct[i];
    }
  }
}

MultipleChoiceQuestion::~MultipleChoiceQuestion() {
  delete[] choices_;
  delete[] correct_choices_;
}

void MultipleChoiceQuestion::Print(bool include_correct_answer) const {
  cout << "Question: " << GetQuestion() << endl;
  cout << "Answer Choices:" << endl;

  for (int i = 0; i < num_choices_; ++i) {
    cout << choices_[i];
    if (include_correct_answer) {
      cout << " - " << (correct_choices_[i] ? "correct" : "incorrect");
    }
    cout << endl;
  }
}

MultipleChoiceQuestion::MultipleChoiceQuestion(
    const MultipleChoiceQuestion& other)
    : Question(other), num_choices_(other.num_choices_) {

  if (num_choices_ == 0) {
    choices_ = nullptr;
    correct_choices_ = nullptr;
    return;
  }

  choices_ = new string[num_choices_];
  correct_choices_ = new bool[num_choices_];

  for (int i = 0; i < num_choices_; ++i) {
    choices_[i] = other.choices_[i];
    correct_choices_[i] = other.correct_choices_[i];
  }
}

void MultipleChoiceQuestion::SetAnswerChoices(
  int num_choices, const string* choices, const bool* correct) {
  delete[] choices_;
  delete[] correct_choices_;

  num_choices_ = num_choices;

  if (num_choices_ == 0) {
    choices_ = nullptr;
    correct_choices_ = nullptr;
    return;
  }

  choices_ = new string[num_choices_];
  correct_choices_ = new bool[num_choices_];

  if (choices == nullptr) {
    for (int i = 0; i < num_choices_; ++i) {
      choices_[i] = "";
    }
  } else {
      for (int i = 0; i < num_choices_; ++i) {
        choices_[i] = choices[i];
      }
    }

  if (correct == nullptr) {
    for (int i = 0; i < num_choices_; ++i) {
      correct_choices_[i] = true;
    }
  } else {
      for (int i = 0; i < num_choices_; ++i) {
        correct_choices_[i] = correct[i];
      }
    }
}

MultipleChoiceQuestion& MultipleChoiceQuestion::operator=(
    const MultipleChoiceQuestion& other) {

  if (this == &other) {
    return *this;
  }

  Question::operator=(other);

  delete[] choices_;
  delete[] correct_choices_;

  num_choices_ = other.num_choices_;

  if (num_choices_ == 0) {
    choices_ = nullptr;
    correct_choices_ = nullptr;
    return *this;
  }

  choices_ = new string[num_choices_];
  correct_choices_ = new bool[num_choices_];

  for (int i = 0; i < num_choices_; ++i) {
    choices_[i] = other.choices_[i];
    correct_choices_[i] = other.correct_choices_[i];
  }
  return *this;
}
}  // namespace csce240_program6
