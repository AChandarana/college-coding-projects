.data
prompt: .asciiz "Enter a positive integer: "
sequenceIndicator: .asciiz "\nThe sequence is as follows: "
stepsMessage: .asciiz "\nNumber of steps before reaching 1: "
maxMessage: .asciiz "\nThe highest value in the sequence was: "
startPrefix: .asciiz "\nThe starting number "
evenSuffix: .asciiz " was even.\n"
oddSuffix: .asciiz " was odd.\n"
space: .asciiz " "

.text
.globl main

main:

# ask the user for input
li $v0, 4
la $a0, prompt
syscall

li $v0, 5
syscall
move $t0, $v0		# $t0 = current number in the sequence

move $t5, $t0		# save original number for even/odd check

li $t1, 0		# $t1 = step counter
move $t2, $t0		# $t2 = highest value seen so far

# print the sequence header
li $v0, 4
la $a0, sequenceIndicator
syscall

loop:

# print the current number
li $v0, 1
move $a0, $t0
syscall

# print a space
li $v0, 4
la $a0, space
syscall

# if the number is 1, exit the loop
beq $t0, 1, done

# determine if the number is even or odd
li $t3, 2
div $t0, $t3
mfhi $t4

beqz $t4, even

# odd case: n = 3n + 1
li $t6, 3
mult $t0, $t6
mflo $t0
addi $t0, $t0, 1
j update

even:
# even case: n = n / 2
srl $t0, $t0, 1

update:

addi $t1, $t1, 1	# increment step counter

# check if this is the highest value so far
ble $t0, $t2, skipMax
move $t2, $t0

skipMax:
j loop

done:

# print the number of steps
li $v0, 4
la $a0, stepsMessage
syscall

li $v0, 1
move $a0, $t1
syscall

# print the highest value reached
li $v0, 4
la $a0, maxMessage
syscall

li $v0, 1
move $a0, $t2
syscall

# determine if the starting number was even or odd
li $t3, 2
div $t5, $t3
mfhi $t4

# print: "The starting number " + <number> + " was even/odd."
li $v0, 4
la $a0, startPrefix
syscall

li $v0, 1
move $a0, $t5
syscall

beqz $t4, printEven

li $v0, 4
la $a0, oddSuffix
syscall
j exit

printEven:
li $v0, 4
la $a0, evenSuffix
syscall

exit:
li $v0, 10
syscall