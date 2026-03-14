.data
    prompt_name:    .asciiz "Enter two numbers (Length Width): "
    area_msg:       .asciiz "The area of the rectangle is: "
    perimeter_msg:  .asciiz "The perimeter of the rectangle is: "
    diagonal_msg:   .asciiz "The diagonal squared is: "
    quotient_msg:   .asciiz "The ratio of the length/width is: "
    remainder_msg:  .asciiz "The remainder of length/width is: "
    goodbye_msg:    .asciiz "Goodbye "
    newline:        .asciiz "\n"
    name_buffer:    .space 100    # Buffer to store the user's name

.text

    # Print "Enter two numbers (Length Width): "
    li $v0, 4
    la $a0, prompt_name
    syscall
    
    # Read x1
    li $v0, 5               # syscall code 5 = read integer
    syscall
    move $t0, $v0           # store l in $t0
    
    # Read y1
    li $v0, 5
    syscall
    move $t1, $v0           # store w in $t1

    # Calculate perimeter = (l+w)*2
    add $t2, $t0, $t1       # t2 = l + w
    mul $t3, $t2, 2         # t3 = 2*(l+w)
    
    # Calculate area = width * height
    mul $t4, $t1, $t0       # t4 = l * w
    
    # Calculate diagonal squared = (l^2 + w^2)
    mul $t5, $t0, $t0
    mul $t6, $t1, $t1
    add $t7, $t5, $t6
    
    # Calculate ratio and remainder = (l % w)
    div $t0, $t1            # LO = l / w, HI = l % w
    mflo $t9                # t8 = remainder
    mfhi $t8		    # t9 = quotient

    # Print "The perimeter of the rectangle is: "
    li $v0, 4
    la $a0, perimeter_msg
    syscall
    
    # Print the perimeter
    li $v0, 1
    move $a0, $t3
    syscall
    
    # Print newline
    li $v0, 4
    la $a0, newline
    syscall
    
    # Print "The area of the rectangle is: "
    li $v0, 4
    la $a0, area_msg
    syscall
    
    # Print the area
    li $v0, 1               # syscall code 1 = print integer
    move $a0, $t4
    syscall
    
    # Print newline
    li $v0, 4
    la $a0, newline
    syscall
    
    # Print "The diagonal squared is: "
    li $v0, 4
    la $a0, diagonal_msg
    syscall
    
    # Print the diagonal squared
    li $v0, 1
    move $a0, $t7
    syscall

    # Print newline
    li $v0, 4
    la $a0, newline
    syscall

    # Print "The ratio of the length/width is: "
    li $v0, 4
    la $a0, quotient_msg
    syscall
    
    # Print the quotient
    li $v0, 1
    move $a0, $t9
    syscall

    # Print newline
    li $v0, 4
    la $a0, newline
    syscall

    # Print "The remainder of length/width is: "
    li $v0, 4
    la $a0, remainder_msg
    syscall

    # Print the remainder
    li $v0, 1
    move $a0, $t8
    syscall
    
    # Print newline
    li $v0, 4
    la $a0, newline
    syscall
    
    # Print "Goodbye "
    li $v0, 4
    la $a0, goodbye_msg
    syscall
    
    # Exit program
    li $v0, 10
    syscall
