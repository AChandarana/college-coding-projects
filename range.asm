.data
promptSpeed: .asciiz "Enter launch speed (m/s): "
promptAngle: .asciiz "Enter launch angle (degrees): "
rangeLabel:  .asciiz "Range = "
meters:      .asciiz " m\n"
shortMsg:    .asciiz "Short range\n"
mediumMsg:   .asciiz "Medium range\n"
longMsg:     .asciiz "Long range\n"

pi:        .float 3.14159265
oneEighty: .float 180.0
two:       .float 2.0
six:       .float 6.0
oneTwenty: .float 120.0
gravity:   .float 9.8
fifty:     .float 50.0
twoHund:   .float 200.0
one:       .float 1.0

.text
.globl main
main:
    lwc1 $f20, pi		# $f20 = ?
    lwc1 $f22, oneEighty	# $f22 = 180.0
    lwc1 $f24, two		# $f24 = 2.0
    lwc1 $f26, six		# $f26 = 6.0
    lwc1 $f28, oneTwenty	# $f28 = 120.0
    lwc1 $f30, gravity		# $f30 = 9.8
    lwc1 $f18, fifty		# $f18 = 50.0
    lwc1 $f16, twoHund		# $f16 = 200.0

    li   $v0, 4
    la   $a0, promptSpeed
    syscall

    li   $v0, 6
    syscall
    mov.s $f2, $f0		# $f2 = v

    # Read angle ?
    li   $v0, 4
    la   $a0, promptAngle
    syscall

    li   $v0, 6
    syscall
    mov.s $f4, $f0		# $f4 = ?

    #   ?_rad = ?_deg * ? / 180
    mul.s $f6, $f4, $f20	# $f6 = ?_deg * ?
    div.s $f6, $f6, $f22	# $f6 = ?_rad

    # Build x = 2 * ?_rad
    mul.s $f8, $f6, $f24	# $f8 = x = 2?

    # sin(x)  x - (x^3)/6 + (x^5)/120
    mul.s $f10, $f8, $f8	# $f10 = x^2
    mul.s $f12, $f10, $f8	# $f12 = x^3
    div.s $f12, $f12, $f26	# $f12 = (x^3)/6
    sub.s $f6, $f8, $f12	# $f6 = x - (x^3)/6
    mul.s $f12, $f10, $f10	# $f12 = x^4
    mul.s $f12, $f12, $f8	# $f12 = x^5
    div.s $f12, $f12, $f28	# $f12 = (x^5)/120
    add.s $f6, $f6, $f12	# $f6 = sin(x) (kinda)

    mul.s $f10, $f2, $f2	# $f10 = v^2

    #   R = (v^2 * sin(x)) / g
    mul.s $f12, $f10, $f6	# $f12 = v^2 * sin(x)
    div.s $f12, $f12, $f30	# $f12 = R

    mov.s $f2, $f12

    li   $v0, 4
    la   $a0, rangeLabel
    syscall

    mov.s $f12, $f2
    li   $v0, 2
    syscall

    li   $v0, 4
    la   $a0, meters
    syscall

    c.le.s $f2, $f18	# if (R <= 50), short
    bc1t shortRange

    c.le.s $f2, $f16	# if (R <= 200), Medium
    bc1t mediumRange

    j longRange		# else, Long

shortRange:
    li   $v0, 4
    la   $a0, shortMsg
    syscall
    j    done

mediumRange:
    li   $v0, 4
    la   $a0, mediumMsg
    syscall
    j    done

longRange:
    li   $v0, 4
    la   $a0, longMsg
    syscall

done:
    li   $v0, 10
    syscall
