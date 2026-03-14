.data
    prompt_msg:     .asciiz "Press the button (enter any integer): "
    gen_msg:        .asciiz "Generating your compliments...\n"
    comp1:          .asciiz "You bring the world joy!\n"
    comp2:          .asciiz "You have great eyebrows!\n"
    comp3:          .asciiz "Your code is good!\n"
    end_msg:        .asciiz "Have a wonderful day!\n"

.text
main:
    # Ask user to press the button
    li $v0, 4
    la $a0, prompt_msg
    syscall

    # Read integer (button press)
    li $v0, 5
    syscall

    # Print generating message
    li $v0, 4
    la $a0, gen_msg
    syscall

    # Print compliment 1
    li $v0, 4
    la $a0, comp1
    syscall

    # Print compliment 2
    li $v0, 4
    la $a0, comp2
    syscall

    # Print compliment 3
    li $v0, 4
    la $a0, comp3
    syscall

    # Print ending message
    li $v0, 4
    la $a0, end_msg
    syscall

    # Exit
    li $v0, 10
    syscall
