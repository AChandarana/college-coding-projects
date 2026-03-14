.data
promptN:     .asciiz "Enter N: "
seqLabel:    .asciiz "Fibonacci sequence: "
space:       .asciiz " "
sumLabel:    .asciiz "\nSum = "
fLabel1:     .asciiz "\nF("
fLabel2:     .asciiz ") is "
evenLabel:   .asciiz "even\n"
oddLabel:    .asciiz "odd\n"

.text
.globl main
main:
    # Read N
    li   $v0, 4
    la   $a0, promptN
    syscall

    li   $v0, 5
    syscall
    move $t0, $v0	# $t0 = N

    # Allocate 4 bites per int
    sll  $a0, $t0, 2	# bytes = N * 4
    li   $v0, 9
    syscall
    move $s0, $v0	# $s0 = base address

    # Store F0=0 and F1=1 with immediate-offset sw
    li   $t1, 0		# F0
    sw   $t1, 0($s0)	# array[0] = 0

    li   $t2, 1		# F1
    sw   $t2, 4($s0)	# array[1] = 1

    # sum = F0 + F1 = 1
    li   $s2, 1

    # Fill loop starts at i=2
    # Address each iteration: sll (i*4) then add (base+offset)
    li   $t3, 2		# i = 2

fill_loop:
    beq  $t3, $t0, fill_done	# if i == N, stop

    add  $t4, $t1, $t2		# next = prev2 + prev1

    # store array[i] = next
    sll  $t5, $t3, 2		# offset = i * 4
    add  $t5, $s0, $t5		# addr = base + offset
    sw   $t4, 0($t5)

    # sum += next
    add  $s2, $s2, $t4

    # prev2 = prev1; prev1 = next
    move $t1, $t2
    move $t2, $t4

    addi $t3, $t3, 1		# i++
    j    fill_loop

fill_done:

    li   $v0, 4
    la   $a0, seqLabel
    syscall

    li   $t3, 0		# i = 0

print_loop:
    beq  $t3, $t0, print_done

    # Calculate the byte address
    sll  $t5, $t3, 2		# offset = i*4
    add  $t5, $s0, $t5		# address = base + offset
    lw   $t6, 0($t5)		# value = array[i]

    # print value
    li   $v0, 1
    move $a0, $t6
    syscall

    # print space if not last element
    addi $t7, $t3, 1		# t7 = i+1
    beq  $t7, $t0, no_space

    li   $v0, 4
    la   $a0, space
    syscall

no_space:
    addi $t3, $t3, 1		# i++
    j    print_loop

print_done:
    # Print sum
    li   $v0, 4
    la   $a0, sumLabel
    syscall

    li   $v0, 1
    move $a0, $s2
    syscall


    # "F(N-1) is even/odd"
    addi $t3, $t0, -1

    sll  $t5, $t3, 2
    add  $t5, $s0, $t5
    lw   $t6, 0($t5)		# last_value = array[N-1]

    # print "\nF("
    li   $v0, 4
    la   $a0, fLabel1
    syscall

    # print the last index
    li   $v0, 1
    move $a0, $t3
    syscall

    # print ") is "
    li   $v0, 4
    la   $a0, fLabel2
    syscall

    li   $t7, 2
    div  $t6, $t7
    mfhi $t8                  # remainder

    beqz $t8, print_even

    # odd
    li   $v0, 4
    la   $a0, oddLabel
    syscall
    j    exit

print_even:
    li   $v0, 4
    la   $a0, evenLabel
    syscall

exit:
    li   $v0, 10
    syscall