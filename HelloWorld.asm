.data
Hello:        .asciiz "Hello User.\n"
Welcome:      .asciiz "Welcome to info echo.\n"

EnterNumber:  .asciiz "Enter a number: "
YouEntered:   .asciiz "\nYou entered: "

EnterName:    .asciiz "\nEnter your name: "
EnterAge:     .asciiz "\nEnter your age: "
EnterHeight:  .asciiz "\nEnter your height (in feet): "

HelloName:    .asciiz "Hello, "
YouAre:       .asciiz ". You are "
YearsOld:     .asciiz " years old and "
FeetTall:     .asciiz " feet tall.\n"

NameBuf:      .space 64

.text
li $v0, 4
la $a0, Hello
syscall

la $a0, Welcome
syscall

la $a0, EnterNumber
syscall

li $v0, 5
syscall
move $t0, $v0

la $a0, YouEntered
li $v0, 4
syscall

move $a0, $t0
li $v0, 1
syscall


la $a0, EnterName
li $v0, 4
syscall

li $v0, 8
la $a0, NameBuf
li $a1, 64
syscall

la $t1, NameBuf
StripLoop:
lb $t2, 0($t1)
beq $t2, $zero, StripDone
beq $t2, 10, MakeNull
addi $t1, $t1, 1
j StripLoop

MakeNull:
sb $zero, 0($t1)

StripDone:
la $a0, EnterAge
li $v0, 4
syscall

li $v0, 5
syscall
move $t0, $v0

la $a0, EnterHeight
li $v0, 4
syscall

li $v0, 6
syscall
mov.s $f4, $f0

la $a0, HelloName
li $v0, 4
syscall

la $a0, NameBuf
li $v0, 4
syscall

la $a0, YouAre
li $v0, 4
syscall

move $a0, $t0
li $v0, 1
syscall

la $a0, YearsOld
li $v0, 4
syscall

mov.s $f12, $f4
li $v0, 2
syscall

la $a0, FeetTall
li $v0, 4
syscall

li $v0, 10
syscall
