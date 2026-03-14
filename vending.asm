.data
    id_prompt:       .asciiz "Enter your Customer ID: "
    welcome_msg:     .asciiz "Welcome Customer "
    isub_prompt:     .asciiz "How many items would you like to purchase? "
    items_left_msg:  .asciiz " items are left. "
    iadd_prompt:     .asciiz "How many items would you like to restock? "
    finish_msg:      .asciiz "Transaction Complete"
    newline:         .asciiz "\n"

.text
main:
    # stock starts at 50
    li $t2, 50

    # Ask for Customer ID
    li $v0, 4
    la $a0, id_prompt
    syscall

    li $v0, 5
    syscall
    move $t0, $v0          # t0 = customer id

    # Welcome message + ID
    li $v0, 4
    la $a0, welcome_msg
    syscall

    li $v0, 1
    move $a0, $t0
    syscall

    li $v0, 4
    la $a0, newline
    syscall

    # Ask purchase amount
    li $v0, 4
    la $a0, isub_prompt
    syscall

    li $v0, 5
    syscall
    move $t1, $v0          # t1 = purchase amount

    sub $t2, $t2, $t1      # stock -= purchase

    # Print updated stock
    li $v0, 1
    move $a0, $t2
    syscall

    li $v0, 4
    la $a0, items_left_msg
    syscall

    li $v0, 4
    la $a0, newline
    syscall

    # Ask restock/return amount
    li $v0, 4
    la $a0, iadd_prompt
    syscall

    li $v0, 5
    syscall
    move $t1, $v0          # t1 = restock amount

    add $t2, $t2, $t1      # stock += restock

    # Print updated stock
    li $v0, 1
    move $a0, $t2
    syscall

    li $v0, 4
    la $a0, items_left_msg
    syscall

    li $v0, 4
    la $a0, newline
    syscall

    # Finish
    li $v0, 4
    la $a0, finish_msg
    syscall

    li $v0, 4
    la $a0, newline
    syscall

    # Exit
    li $v0, 10
    syscall
