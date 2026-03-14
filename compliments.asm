.data
prompt: .asciiz "Press the button (enter any integer): "
gen:    .asciiz "Generating your compliments...\n"
close:  .asciiz "Have a wonderful day!\n"

# Bank of compliments
c1: .asciiz "\"You have a radiant smile!\"\n"
c2: .asciiz "\"Your creativity is inspiring!\"\n"
c3: .asciiz "\"You light up every room!\"\n"
c4: .asciiz "\"You make the world better!\"\n"
c5: .asciiz "\"Your kindness is contagious!\"\n"

.text
.globl main
main:
    li   $v0, 4
    la   $a0, prompt
    syscall	# print prompt

    li   $v0, 5
    syscall		# read int
    move $t0, $v0	# $t0 = n

    li   $v0, 4
    la   $a0, gen
    syscall		# print generating... message

    # r = n % 5
    li   $t1, 5		# $t1 = 5 (divisor)
    divu $t0, $t1	# divide n by 5
    mfhi $t2		# $t2 = remainder

    # Shift remainder into 1 - 5
    addiu $t2, $t2, 1	# $t2 = r + 1

    li   $s1, 3		# $s1 = 3 ( number of compliments )

    # Waterfall
    li   $t3, 1
    beq  $t2, $t3, p1	# if (r == 1) jump to p1

    li   $t3, 2
    beq  $t2, $t3, p2	# if (r == 2) jump to p2

    li   $t3, 3
    beq  $t2, $t3, p3	# if (r == 3) jump to p3

    li   $t3, 4
    beq  $t2, $t3, p4	# if (r == 4) jump to p4

    j    p5		# else, jump to p5

p1:
    li   $v0, 4
    la   $a0, c1
    syscall		# print compliment 1

    subi $s1, $s1, 1	# decrement counter

    beqz $s1, done	# if ( $s1 == 0 ), done

p2:
    li   $v0, 4
    la   $a0, c2
    syscall		# print compliment 2

    subi $s1, $s1, 1	# decrement counter

    beqz $s1, done	# if ( $s1 == 0 ), done

p3:
    li   $v0, 4
    la   $a0, c3
    syscall		# print compliment 3

    subi $s1, $s1, 1	# decrease counter

    beqz $s1, done	# stop when counter is 0

p4:
    li   $v0, 4
    la   $a0, c4
    syscall		# print compliment 4

    subi $s1, $s1, 1	# decrement counter

    beqz $s1, done	# stop when counter is 0

p5:
    li   $v0, 4
    la   $a0, c5
    syscall		# print compliment 5

    subi $s1, $s1, 1	# decrement the counter

    beqz $s1, done	# done when counter is 0
    
    j    p1		# hop back up to c1

done:
    li   $v0, 4
    la   $a0, close
    syscall		# print the closing message

    li   $v0, 10	# end program
    syscall